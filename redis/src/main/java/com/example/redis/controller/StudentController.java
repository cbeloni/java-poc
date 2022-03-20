package com.example.redis.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.entity.Student;
import com.example.redis.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentRepository studentRepository;
	
	@GetMapping
	public Student byId(@PathParam("id") String id) {
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Falha ao consultar"));		
	}
	
	@PostMapping
	public Student save(@RequestBody Student student) {
		return studentRepository.save(student);
	}	
}
