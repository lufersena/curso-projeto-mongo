package com.lucassena.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucassena.workshopmongo.domain.Post;
import com.lucassena.workshopmongo.exception.ObjectNotFoundException;
import com.lucassena.workshopmongo.repository.PostRepository;

@Service // fala para o spring que essa classe vai ser um seviço injetavel em outras classes
public class PostService {

	@Autowired //spring procura a definiçao do objeto(PostRepository) e instância o objeto 
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post>obj =repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrad"));
	}
	
	public List<Post> findByTitle (String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
