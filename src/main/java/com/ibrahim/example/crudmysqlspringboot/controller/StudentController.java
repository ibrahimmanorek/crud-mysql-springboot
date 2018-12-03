package com.ibrahim.example.crudmysqlspringboot.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibrahim.example.crudmysqlspringboot.model.Student;
import com.ibrahim.example.crudmysqlspringboot.pojo.ResponseData;
import com.ibrahim.example.crudmysqlspringboot.repository.StudentRepository;
import com.ibrahim.example.crudmysqlspringboot.utils.ResourceNotFoundException;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("students")
	public List<Student> getList(){
		return studentRepository.findAll();
	}
	
	@PostMapping("students")
	public Student insertStudent(@Valid @RequestBody Student student){
		return studentRepository.save(student);
	}
	
	@PutMapping("students/{id}")
	public Student updatedStudent(@PathVariable(value = "id") Long id, @Valid @RequestBody Student student) {
		Student student2 = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Data", "id", id));

		student2.setName(student.getName());
		student2.setPassword(student.getPassword());
		
		return studentRepository.save(student2);
	}
	
	@GetMapping("students/{id}")
	public Student getId(@PathVariable(value = "id") Long id) {
		Student student2 = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Data", "id", id));
		
		return student2;
	}
	
	@DeleteMapping("students/{id}")
	public ResponseEntity<?> deleteId(@PathVariable(value = "id") Long id) {
		Student student2 = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Data", "id", id));
		
		studentRepository.delete(student2);
		
		ResponseData res = new ResponseData();
		res.setStatus("000");
		res.setMessage("Success Delete");
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
