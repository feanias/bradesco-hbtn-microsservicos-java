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
		String message = "Id válido";
		if(id > 200) {
			return message;
		}else {
			throw new UserIdException(String.valueOf(id));
		}
	}
	
	@GetMapping("/user-name/{userName}")
	public String findUserByName (@PathVariable String userName) {
		String message = "Username Inválido";
		if(userName.length() <= 3) {
			return message;
		}else {
			throw new UserNameException(userName);
		}
	}
	
	@GetMapping("/user-cpf/{cpf}")
	public String findUserByCPF (@PathVariable String cpf) {
		 String msg = "CPF Inválido";
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
