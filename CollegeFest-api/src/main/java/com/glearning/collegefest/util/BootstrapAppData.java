package com.glearning.collegefest.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.glearning.collegefest.entity.Role;
import com.glearning.collegefest.entity.Student;
import com.glearning.collegefest.entity.User;
import com.glearning.collegefest.repository.StudentRepository;
import com.glearning.collegefest.repository.UserRepository;

@Component
public class BootstrapAppData {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertData(ApplicationReadyEvent event) {
		
		Student student =new Student();
		student.setFirstName("Suresh");
		student.setLastName("Reddy");
		student.setCourse("B.Tech");
		student.setCountry("India");
		
		Student student1 =new Student();
		student1.setFirstName("Murali");
		student1.setLastName("Mohan");
		student1.setCourse("B.Arch");
		student1.setCountry("Canada");
		
		Student student2 =new Student();
		student2.setFirstName("Tanya");
		student2.setLastName("Gupta");
		student2.setCourse("B.Com");
		student2.setCountry("USA");
		
		Student student3 =new Student();
		student3.setFirstName("Daniel");
		student3.setLastName("Denson");
		student3.setCourse("B.Tech");
		student3.setCountry("New Zealand");
		
		this.studentrepository.save(student);
		this.studentrepository.save(student1);
		this.studentrepository.save(student2);
	    this.studentrepository.save(student3);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event) {
		
		User user1 = new User();
		user1.setUsername("user1");
		user1.setPassword(this.passwordEncoder.encode("welcome"));
		
		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword(this.passwordEncoder.encode("welcome"));
		
		Role userRole= new Role();
		userRole.setName("ROLE_USER");
		
		Role adminRole= new Role();
		adminRole.setName("ROLE_ADMIN");
		
		List<Role> roles = user1.getRoles();
		roles.add(userRole);
		
		Role user2Role= new Role();
		user2Role.setName("ROLE_USER");
		
		List<Role> user2Roles = user2.getRoles();
		user2Roles.add(adminRole);
		user2Roles.add(user2Role);
		
		this.userRepository.save(user1);
		this.userRepository.save(user2);
		
	}

}
