package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Student;
import com.demo.Service.StudentServiceInterface;
/*
@GetMapping: Used to retrieve resources (data) from the server.
@PostMapping: Used to create a new resource.
@PutMapping: Used to update an existing resource.
@DeleteMapping: Used to delete a resource.
@PatchMapping (less commonly used): Used to partially update a resource*/
@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	
	@PostMapping("/details")
	public ResponseEntity<String> InsertDetails(@RequestBody Student student){
		String status = studentServiceInterface.insertStudentDetails(student);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/detailsById/{id}")
	public ResponseEntity<Student> getDetailsById(@PathVariable Integer id){
		Student student = studentServiceInterface.getById(id);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	@GetMapping("/detailsByEmail/{email}")
	public ResponseEntity<Student> getDetailsByEmail(@PathVariable String email){
		Student student = studentServiceInterface.findByEmail(email);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@GetMapping("/detailsByMbno/{mbno}")
	public ResponseEntity<Student> getDetailsByMbno(@PathVariable long mbno){
		Student student = studentServiceInterface.findByMbno(mbno);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@GetMapping("/allStudentDetails")
	public ResponseEntity<List<Student>> getAllStudentsDetails(Student student){
		List<Student> allstudent = studentServiceInterface.getAllStudentDetails();
		return new ResponseEntity<>(allstudent,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmailById/{email}/{id}")
	public ResponseEntity<Student> updateEmailById(@PathVariable String email, @PathVariable int id){
		Student updateEmail = studentServiceInterface.updateEmailByUsingId(id, email);
		return new ResponseEntity<>(updateEmail,HttpStatus.OK);
	}
	@PutMapping("/updateMbnoByEmail/{mbno}/{email}")
	public ResponseEntity<Student> updateMbnoByEmail(@PathVariable String email, @PathVariable long mbno){
		Student updateMbno = studentServiceInterface.updateMbnoByUsingEmail(email, mbno);
		return new ResponseEntity<>(updateMbno,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		studentServiceInterface.deleteById(id);
		return ResponseEntity.ok().body("Delected Successfully");
	}
	
}
