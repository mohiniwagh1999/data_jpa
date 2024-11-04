package com.jpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jpa.entity.Employee;
import com.jpa.repo.EmpRepo;

@Service
public class EmpService {
	
	private EmpRepo repo;
	
	//ci
	public EmpService( EmpRepo repo)
	{
		this.repo=repo;
	}
	
	//save one emp
	public void saveEmp()
	{
		System.out.println("impl class"+repo.getClass().getName());
		Employee e=new Employee();
		e.setId(2);
		e.setName("mogha");
		e.setSalary(15000);
		//proxy class
		repo.save(e);
		System.out.println("record save......");
	}
	
	
	//save all emp
	public void saveEmps()
	{
		Employee e1=new Employee(3,"rani",3000);
		Employee e2=new Employee(4,"riru",3000);
		Employee e3=new Employee(5,"shyam",3000);
		Employee e4=new Employee(6,"papu",3000);
		List<Employee> asList = Arrays.asList(e1,e2,e3,e4);
		repo.saveAll(asList);
		System.out.println("save all records");
	}
	//find emp by id
	public void findempId(Integer i)
	{
		Optional<Employee> byId = repo.findById(i);
		if(byId.isPresent())
		{
			System.out.println(byId.get());
		}
		else
		{
			System.out.println("record not foundd");
		}
	}
	//find emp by ids
	public void findempids(List<Integer>ids)
	{
		List<Employee> allById = repo.findAllById(ids);
		allById.forEach(System.out::println);
	}
	//find all emp
	public void getallemp()
	{
		
		List<Employee> all = repo.findAll();
		all.forEach(System.out::println);
	}
	//find by name
	public void getbyname(String name)
	{
		System.out.println(  repo.findByName(name));
		
	}
	
	//find by salary
	public void getbysalary(Integer salary)
	{
		//System.out.println(repo.findBySalary(salary));
		System.out.println(repo.findBySalaryGreaterThan(salary));
	}
	//call custom query method
	public void customQuery()
	{
		List<Employee> allemphql = repo.getAllemphql();
		allemphql.forEach(System.out::println);
	}
	
	public void custom2(Integer id)
	{
		Employee byId = repo.getById(id);
		System.out.println(byId);
	}

	public void customsql()
	{
		List<Employee> allempSql = repo.getAllempSql();
		allempSql.forEach(System.out::println);
	}
}
