package com.example.mywebapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.mywebapp.model.Post;

import java.util.Arrays;
import org.bson.Document;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;

@Component

public class SearchRepositoryImplementation implements SearchReapository {
    
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text){
        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("joblisting");
        MongoCollection<Document> collection = database.getCollection("Jobpost");
AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));
        result.forEach(doc-> posts.add(converter.read(Post.class, doc)));
        return posts;
    }
}
