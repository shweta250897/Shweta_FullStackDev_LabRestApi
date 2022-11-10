package com.glearning.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.collegefest.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


	

}
