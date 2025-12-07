package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/user-id/{id}")
	public String findUserById(@PathVariable int id) {
		String message = "You have entered valid ID";
		if(id > 0 && id < 100) {
			return message;
		}else {
			throw new UserIdException(String.valueOf(id));
		}
	}
	
	@GetMapping("/user-name/{userName}")
	public String findUserByName (@PathVariable String userName) {
		String message = "You have entered valid USERNAME";
		if(userName.length() > 3 && userName.length() < 15) {
			return message;
		}else {
			throw new UserNameException(userName);
		}
	}
	
	@GetMapping("/user-cpf/{cpf}")
	public String findUserByCPF (@PathVariable String cpf) {
		 String msg = "You have entered valid CPF";
		 if (isCPF(cpf)) {
	            return msg;
	        } else {
	            throw new CPFException(cpf);
	        }
	}
	
	public boolean isCPF(String cpf) {
		int len = cpf.length();
        return len > 3 && len < 15;
	}

}
