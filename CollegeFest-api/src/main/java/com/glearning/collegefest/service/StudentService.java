package com.glearning.collegefest.service;

import java.util.List;

import com.glearning.collegefest.entity.Student;

public interface StudentService {
	
	public Student save(Student student);
	
	public List<Student> findAll();
	
	public Student findById(int id);
	
	public void deleteStudentById(int id);

}
