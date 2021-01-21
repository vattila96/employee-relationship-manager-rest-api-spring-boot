package com.attilavarga.employee.relationship.manager.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attilavarga.employee.relationship.manager.rest.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
