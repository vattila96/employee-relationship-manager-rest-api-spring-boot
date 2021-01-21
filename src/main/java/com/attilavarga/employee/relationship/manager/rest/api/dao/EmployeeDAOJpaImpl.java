package com.attilavarga.employee.relationship.manager.rest.api.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attilavarga.employee.relationship.manager.rest.api.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee");
		
		@SuppressWarnings("unchecked")
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}
}