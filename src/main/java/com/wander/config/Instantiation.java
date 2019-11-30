package com.wander.config;

import com.wander.domain.Post;
import com.wander.domain.User;
import com.wander.repository.PostRepository;
import com.wander.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        User maria = new User(null, "Maria Augusto", "maria@emaol.com");
        User alex = new User(null, "Alex Batista", "alex@emaol.com");
        User wander = new User(null, "Wander S", "wander@emaol.com");

        userRepository.saveAll(Arrays.asList(maria, alex, wander));

        Post post1 = new Post(null, sdf.parse("21/12/2019"), "Go travel", "I'm going to sao paulo!!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/12/2019"), "Beautiful eyes", "Just look your eyes", new AuthorDTO (alex));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
