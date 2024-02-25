package com.example.mywebapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.PostRepository;
import com.example.mywebapp.SearchReapository;
import com.example.mywebapp.model.Post;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;
    @Autowired
    SearchReapository srepo;

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect(null);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
    
}
