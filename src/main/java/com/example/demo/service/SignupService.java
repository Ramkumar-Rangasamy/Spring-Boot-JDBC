package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Response;
import com.example.demo.model.SignupModel;

@Service 
public interface SignupService { //heap memory which is temporary  storage or loading of data's

	public Response addUsers(SignupModel data);

	public Response deleteUsers();

	public Response getAllUsers();

	public Response getUserById();

	public Response updateUsers();
}
