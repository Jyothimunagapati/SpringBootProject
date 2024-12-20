package com.restservice.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.demo.entity.Employee;
import com.restservice.demo.service.EmployeeService;
 
/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
public class EmployeeRestController {
  
 @Autowired
 private EmployeeService employeeService;
  
 @GetMapping("/api/employees")
 public List<Employee> getEmployees() {
  List<Employee> employees = employeeService.retrieveEmployees();
  return employees;
 }
  
 @GetMapping("/api/employees/{employeeId}")
 public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
  return employeeService.getEmployee(employeeId);
 }
  
 @PostMapping("/api/employees")
 public Employee saveEmployee(@RequestBody Employee employee){
	Employee employee1 = employeeService.saveEmployee(employee);
  System.out.println("Employee Saved Successfully aaaa");
  return employee1;
 }
  
 @DeleteMapping("/api/employees/{employeeId}")
 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully done 1111111");
 }
  
 @PutMapping("/api/employees/{employeeId}")
 public void updateEmployee(@RequestBody Employee employee,
   @PathVariable("employeeId")Long employeeId){
  Employee emp = employeeService.getEmployee(employeeId);
  if(emp != null){
   employeeService.updateEmployee(employee);
  }
   
 }
 @PatchMapping("/api/employees/{employeeId}")
 public void modifyEmployee(@RequestBody Employee employee,
   @PathVariable("employeeId")Long employeeId){
  Employee emp = employeeService.getEmployee(employeeId);
  if(employee.getDepartment() != null){
	  emp.setDepartment(employee.getDepartment());
  }
  if(employee.getName() != null){
	  emp.setName(employee.getName());
  }
  if(employee.getSalary() != null){
	  emp.setSalary(employee.getSalary());
  }
   employeeService.updateEmployee(emp);
  }
   
}