package com.jpa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.service.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext c=SpringApplication.run(Application.class, args);
		EmpService e=c.getBean(EmpService.class);
		//e.saveEmp();
		//e.saveEmps();
		//e.findempId(14);
		
		//e.findempids(Arrays.asList(1,2,3,4));
		//e.getallemp();
		//e.getbyname("mohini");
		//e.getbysalary(3000);
		//e.customQuery();
		//e.custom2(4);
		e.customsql();
	}

}
