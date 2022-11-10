package com.glearning.collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.collegefest.entity.Student;
import com.glearning.collegefest.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> fetchAllStudents(){
		return this.studentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Student fetchStudentById(@PathVariable("id") int id){
		return this.studentService.findById(id);
	}
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return this.studentService.save(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") int id) {
		this.studentService.deleteStudentById(id);
	}
	

}
