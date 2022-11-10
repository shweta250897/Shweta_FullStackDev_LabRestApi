package com.glearning.collegefest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.collegefest.entity.Student;
import com.glearning.collegefest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public Student save(Student student) {
		Student savedstudent = this.studentRepository.save(student);
		return savedstudent;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students=this.studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int id) {
		Optional<Student> optionalStudent = this.studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			throw new IllegalArgumentException("Invalid student is is passed");
		}
		
	}

	@Override
	public void deleteStudentById(int id) {
		this.studentRepository.deleteById(id);
	}

}
