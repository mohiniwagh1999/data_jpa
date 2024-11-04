package com.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer> {
	//select * from emp where name=?;
	public List<Employee> findByName(String name);
	//select * from emp where salary=?
	//its used to get non primary records
	public List<Employee> findBySalary(Integer salary);
	
	public List<Employee> findBySalaryGreaterThan(Integer salary);
	//write out own sql query execute our own query
	//HQL
	@Query("from Employee")
	public List<Employee> getAllemphql();
	@Query("from Employee where id=:id")
	public Employee getById(Integer id);
	//SQL
	@Query(value="select * from employee",nativeQuery=true)
	public List<Employee> getAllempSql();
	

}
