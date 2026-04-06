package com.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Entity.Student;

@Service
public interface StudentServiceInterface {
	public String insertStudentDetails(Student student);
	public Student getById(Integer id);
	public Student findByEmail(String email);
	public Student findByMbno(long mbno);
	public List<Student> getAllStudentDetails();
	public Student updateEmailByUsingId(int id, String email );
	public Student updateMbnoByUsingEmail(String email, long mbno);
	public String deleteById(Integer id);
}
