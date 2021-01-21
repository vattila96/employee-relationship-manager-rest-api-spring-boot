package com.attilavarga.employee.relationship.manager.rest.api.dao;

import java.util.List;

import com.attilavarga.employee.relationship.manager.rest.api.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
