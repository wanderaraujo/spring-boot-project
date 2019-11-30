package com.wander.service;

import com.wander.domain.Post;
import com.wander.exception.ObejectNotFoundException;
import com.wander.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);

        if(post.equals(Optional.empty())){
            throw new ObejectNotFoundException("Object not found!");
        }
        return post.get();
    }

    public List<Post> findByTitle(String text){
        return repo.searchByTitle(text);
    }
}
