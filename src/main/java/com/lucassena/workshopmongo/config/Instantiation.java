package com.lucassena.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucassena.workshopmongo.domain.Post;
import com.lucassena.workshopmongo.domain.User;
import com.lucassena.workshopmongo.dto.AuthorDTO;
import com.lucassena.workshopmongo.repository.PostRepository;
import com.lucassena.workshopmongo.repository.UserRepository;

@Configuration //sprig entende que isso é uma configuração
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; //injeta o user repository para operções com o bd
	
	@Autowired
	private PostRepository postRepository; //injeta o post repository para operções com o bd	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //persiste objeto user 
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo agora. Abraços!",new AuthorDTO(maria) );
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia","Acordei feliz hoje!", new AuthorDTO(maria)); 
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
