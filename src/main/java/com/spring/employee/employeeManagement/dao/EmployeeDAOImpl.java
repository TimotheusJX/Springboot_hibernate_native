package com.spring.employee.employeeManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.employee.employeeManagement.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		//get current hibernate session
		Session currentSess = entityManager.unwrap(Session.class);
		
		// Using native hibernate api		
		Query<Employee> query = currentSess.createQuery("from Employee", Employee.class);
		
		//execute
		List<Employee> employeeList = query.getResultList();
		
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		//get current hibernate session
		Session currentSess = entityManager.unwrap(Session.class);
		
		Employee employee = currentSess.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void deleteById(int id) {
		//get current hibernate session
		Session currentSess = entityManager.unwrap(Session.class);
		
		// Using native hibernate api		
		Query<Employee> query = currentSess.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		//get current hibernate session
		Session currentSess = entityManager.unwrap(Session.class);
		
		//if id = 0 or null, new employee will be created, rule still applies in this case
		currentSess.saveOrUpdate(employee);
	}

}
