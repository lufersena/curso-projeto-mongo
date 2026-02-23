package com.lucassena.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucassena.workshopmongo.domain.Post;
import com.lucassena.workshopmongo.resources.util.URL;
import com.lucassena.workshopmongo.services.PostService;

@RestController
@RequestMapping(value= "/posts") //caminho do end point
public class PostResource {

	@Autowired
	private PostService service;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)//metodo end point rest caminho (users/id) 
	public ResponseEntity<Post> findById(@PathVariable String id){// anotation que casa as id
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}
	
	@RequestMapping(value ="/titlesearch",method = RequestMethod.GET)//metodo end point rest caminho (users/titlesearch) 
	public ResponseEntity<List<Post>> findByTitle(@RequestParam (value="text", defaultValue ="")String text){// anotation para consultas com parametros (text)
		text = URL.decodeParam(text); // decodifica o paramentro
		List<Post>list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);	
	}
}