package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Student;
import com.demo.Repository.StudentRepository;

@Service
public class StudentServiceImple implements StudentServiceInterface{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public String insertStudentDetails(Student student) {
		studentRepository.save(student);
		return "Success";
	}

	@Override
	public Student getById(Integer id) {

	    Optional<Student> findById = studentRepository.findById(id);

	    // Optional<Student> is used to avoid NullPointerException
	    if (findById.isPresent()) {
	        return findById.get();   // ✅ return the value
	    } else {
	        throw new RuntimeException("Student not found with id " + id);
	    }
	}

	@Override
	public Student findByEmail(String email) {
		Student status = studentRepository.findByEmail(email);
		if(status == null) {
			throw new RuntimeException("Email Id is not present "+email);
		}
		return status;
	   }

	@Override
	public Student findByMbno(long mbno) {
		Student findByMbno = studentRepository.findByMbno(mbno);
		if(findByMbno != null) {
			return findByMbno;
		}else {
			throw new RuntimeException("No record of the number "+mbno);
		}
	}

	@Override
	public List<Student> getAllStudentDetails() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student updateEmailByUsingId(int id, String email) {
	    // we use Optional<> for avoiding NullPointerException
	    Optional<Student> student = studentRepository.findById(id);
	    if (student.isEmpty()) {
	        throw new RuntimeException("Student id is not found " + id);
	    }
	    Student s = student.get();   // ✅ extract Student
//	    Optional<Student> = 📦 Box
//	    Student = 🎁 Item inside the box
	    s.setEmail(email);           // ✅ set email
	    return studentRepository.save(s);  // ✅ save Student
	}

	@Override
	public Student updateMbnoByUsingEmail(String email, long mbno) {
		Student student = studentRepository.findByEmail(email);
		if(student == null) {
			throw new RuntimeException("Student email is not in the recordes "+email);
		}
		student.setMbno(mbno);
		return studentRepository.save(student);
	}
	
	@Override
	public String deleteById(Integer id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return "Deleted successfully";
		}else {
			return "No Records found";
		}
	}

}
