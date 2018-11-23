package com.cg.springmvcone.dao;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcone.dto.Employee;

@Repository("emplyeedao")
public class EmployeeDaoImpl implements IEmployeeDao{
       
       @PersistenceContext
       EntityManager em;

       @Override
       public int addEmployeeData(Employee emp) {
              // TODO Auto-generated method stub
              em.persist(emp);
              em.flush();
              return emp.getEmpId();
       }

       @SuppressWarnings("unchecked")
	   @Override
       public List<Employee> showAllEmployee() {
              // TODO Auto-generated method stub
              Query queryone = em.createQuery("FROM Employee");
              List<Employee> employees = queryone.getResultList();
              
              return employees;
       }

       @Override
       public void deleteEmployee(int empId) {
              // TODO Auto-generated method stub
              Query query = em.createQuery("DELETE FROM Employee WHERE empId=:eid");
              query.setParameter("eid", empId);
              query.executeUpdate();
              
       }

      
       @Override
       public Employee searchEmployee(int empId) {
    	  
           
    	   Query query = em.createQuery("SELECT e FROM Employee e WHERE e.empId=:eid");
           query.setParameter("eid", empId);
     
           return (Employee) query.getSingleResult();
           
    	  
       }
       
       @Override
       public void updateEmployee(Employee emp) {
              // TODO Auto-generated method stub
    	 
           
    	   em.merge(emp);
    	   em.flush();
              
       }


}

