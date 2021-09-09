package com.example.course.resources;

import java.util.List;

import com.example.course.entities.User;
import com.example.course.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// (value = "/{id}") "avisa" que vai receber um id como parâmetro
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){ // Para aceitar como parametro que vai chegar com a URL, coloca-se o @PathVariable
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
