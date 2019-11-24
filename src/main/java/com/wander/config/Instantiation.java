package com.wander.config;

import com.wander.domain.User;
import com.wander.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User maria = new User(null, "Maria Augusto", "maria@emaol.com");
        User alex = new User(null, "Alex Batista", "alex@emaol.com");
        User wander = new User(null, "Wander S", "wander@emaol.com");

        userRepository.saveAll(Arrays.asList(maria, alex, wander));
    }
}
