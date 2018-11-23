package com.cg.springmvcone.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "employeemanagement")
public class Employee {
       
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
     //  @SequenceGenerator(name = "emp_seq",sequenceName="emp_seq_eid")
       @Column
       private Integer empId;
       
       @Column
       @NotEmpty(message = "Name should not be empty")
       private String empName;
       
       @Column
       private String empDesignation;
       @Column
       @NotNull(message = "Employee salary should not be null")
       private Double empSalary;
       
       @Column
       private String empGender;
       public Integer getEmpId() {
              return empId;
       }
       public void setEmpId(Integer empId) {
              this.empId = empId;
       }
       public String getEmpName() {
              return empName;
       }
       public void setEmpName(String empName) {
              this.empName = empName;
       }
       public String getEmpDesignation() {
              return empDesignation;
       }
       public void setEmpDesignation(String empDesignation) {
              this.empDesignation = empDesignation;
       }
       public Double getEmpSalary() {
              return empSalary;
       }
       public void setEmpSalary(Double empSalary) {
              this.empSalary = empSalary;
       }
       public String getEmpGender() {
              return empGender;
       }
       @Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empDesignation=" + empDesignation + ", empSalary="
				+ empSalary + ", empGender=" + empGender + "]";
	}
	public void setEmpGender(String empGender) {
              this.empGender = empGender;
       }

       
       
}


