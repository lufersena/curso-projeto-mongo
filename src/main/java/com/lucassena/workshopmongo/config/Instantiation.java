package com.lucassena.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucassena.workshopmongo.domain.User;
import com.lucassena.workshopmongo.repository.UserRepository;

@Configuration //sprig entende que isso é uma configuração
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; //injeta o user repository para operções com o bd
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
