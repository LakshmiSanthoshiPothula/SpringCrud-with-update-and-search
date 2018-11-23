package com.cg.springmvcone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvcone.dto.Employee;
import com.cg.springmvcone.service.IEmployeeService;

@Controller
public class MyController {
	@Autowired
	IEmployeeService employeeservice;
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String getAll(){
		return "home";
		
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addEmployee(@ModelAttribute("my") Employee emp
			,Map<String,Object> model ){
		List<String> myDeg=new ArrayList<>();
		myDeg.add("SoftWare Engg");
		myDeg.add("Sr Consoltant");
		myDeg.add("Manager");
		model.put("deg",myDeg);
		return "addemployee";
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@Valid@ModelAttribute("my") 
	Employee emp,BindingResult result,
			Map<String,Object> model){
		//System.out.println("Name is "+emp.getEmpName());
		int id=0;
		if(result.hasErrors()){
			List<String> myDeg=new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg",myDeg);
			return new ModelAndView("addemployee");
		}else{
		 id=employeeservice.addEmployeeData(emp);
		}
		return new ModelAndView("sucess","edata",id);
		
	}
	
	
	@RequestMapping(value="show",method=RequestMethod.GET)
	public ModelAndView showAllEmployee(){
		List<Employee> myAllData=employeeservice.showAllEmployee();
		return new ModelAndView("showall","temp", myAllData);
		}
	
	
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteEmployee(){
		
		return "deleteemployee";
		
	}
	
	
	@RequestMapping(value="dodelete",method=RequestMethod.GET)
	public String employeeDelete(@RequestParam("eid") int id){
		//System.out.println("Id is ..."+id);
		employeeservice.deleteEmployee(id);
		return "deletesuccess";
		
	}
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String searchEmployee(){
		
		return "searchemployee";
		
	}
	
	@RequestMapping(value="dosearch",method=RequestMethod.GET)
	public ModelAndView showOneEmployee(@RequestParam("eid") int id){
		Employee e=employeeservice.searchEmployee(id);
		return new ModelAndView("showone","temp", e);
		}
	
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateEmployee(){
		
		return "updateemployee";
		
	}
	
	

	
	
	
	@RequestMapping(value="addupdate",method=RequestMethod.GET)
	public ModelAndView addUpdateEmployeeDetails(@ModelAttribute("my") Employee emp
			,Map<String,Object> model,@RequestParam("eid") int id){
		emp=employeeservice.searchEmployee(id);
		List<String> myDeg=new ArrayList<>();
		myDeg.add("SoftWare Engg");
		myDeg.add("Sr Consultant");
		myDeg.add("Manager");
		model.put("deg",myDeg);
		return new ModelAndView("addupdateddetails","temp", emp);
	}
	
	@RequestMapping(value="insertupdatedata",method=RequestMethod.POST)
	public ModelAndView insertUpdatedEmployee(@Valid@ModelAttribute("my") 
	Employee emp,BindingResult result,
			Map<String,Object> model ){
		//System.out.println("Name is "+emp.getEmpName());
		
		if(result.hasErrors()){
			List<String> myDeg=new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg",myDeg);
			return new ModelAndView("addupdateddetails");
		}else{
			
			employeeservice.updateEmployee(emp);
			
			List<Employee> updatedList=employeeservice.showAllEmployee();
			
			return new ModelAndView("updatesuccess","temp",updatedList);
			
		}
		
	}
	
	/*
	@RequestMapping(value="doupdate",method=RequestMethod.GET)
	public ModelAndView showUpdatedEmployee(@RequestParam("eid") int id){
		
		Employee emp=employeeservice.searchEmployee(id);
		employeeservice.updateEmployee(emp);
		List<Employee> updatedList=employeeservice.showAllEmployee();
		return new ModelAndView("updatesuccess","temp", updatedList);
		}*/
	

}
