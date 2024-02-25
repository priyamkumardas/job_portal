package com.example.mywebapp;

import java.util.List;

import com.example.mywebapp.model.Post;

public interface SearchReapository {

    List<Post> findByText(String text);
    
}
