package com.wander.service;

import com.wander.config.UserDTO;
import com.wander.domain.User;
import com.wander.exception.ObejectNotFoundException;
import com.wander.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);

        if(user.equals(Optional.empty())){
            throw new ObejectNotFoundException("Object not found!");
        }
        return user.get();
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getName());
    }
}
