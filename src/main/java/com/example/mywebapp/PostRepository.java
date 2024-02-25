package com.example.mywebapp;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mywebapp.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
}
