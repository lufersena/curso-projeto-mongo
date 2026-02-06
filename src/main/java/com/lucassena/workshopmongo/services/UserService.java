package com.lucassena.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucassena.workshopmongo.domain.User;
import com.lucassena.workshopmongo.dto.UserDTO;
import com.lucassena.workshopmongo.exception.ObjectNotFoundException;
import com.lucassena.workshopmongo.repository.UserRepository;

@Service // fala para o spring que essa classe vai ser um seviço injetavel em outras classes
public class UserService {

	@Autowired //spring procura a definiçao do objeto(UserRepository) e instância o objeto 
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User>obj =repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrad"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
