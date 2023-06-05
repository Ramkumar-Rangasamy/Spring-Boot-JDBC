package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SignupDao;
import com.example.demo.model.Response;
import com.example.demo.model.SignupModel;

@CrossOrigin("*") // hit all users other c
@RestController
@RequestMapping("/auth")

public class SignupController {
  
	SignupDao dao=new SignupDao();    //normal object
	
	//@Autowired    //dao and controller connected (annotation create object)
	
	SignupDao dao1; 
	
	@PostMapping("/insert")
	public ResponseEntity<Response> addUsers(@RequestBody SignupModel data){
		
		return ResponseEntity.ok(dao.addUsers(data));
		
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteUsers(){
		
		return ResponseEntity.ok(dao.deleteUsers());
	}
	
	
	@GetMapping("/retriveAll")
	public ResponseEntity<Response> getAllUsers(){
		
		return ResponseEntity.ok(dao.getAllUsers());
	}
	
	
	@GetMapping("/retrive")
	public ResponseEntity<Response> getUserById(){
		
		return ResponseEntity.ok(dao.getUserById());
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Response> updateUsers(){
		
		return ResponseEntity.ok(dao.updateUsers());	
	}
	
	
}
