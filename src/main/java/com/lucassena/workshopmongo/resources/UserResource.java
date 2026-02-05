package com.lucassena.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucassena.workshopmongo.domain.User;
import com.lucassena.workshopmongo.dto.UserDTO;
import com.lucassena.workshopmongo.services.UserService;

@RestController
@RequestMapping(value= "/users") //caminho do end point
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)//metodo end point rest caminho (users) 
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list =service.findAll();
		List<UserDTO>listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)//metodo end point rest caminho (users/id) 
	public ResponseEntity<UserDTO> findById(@PathVariable String id){// anotation que casa as id
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
		
	}
	
	
}
