package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    private static ArrayList<Post> POSTS=new ArrayList<>();

    static {
        Post post1=new Post() ;
        post1.setTitle("NEWS");
        post1.setBody("Earthquake in delhi,punjab,hp");
        post1.setDate(new Date());
        POSTS.add(post1);

        Post post2=new Post() ;
        post2.setTitle("MUSIC");
        post2.setBody("Selena Gomez is going to launch her spanish album");
        post2.setDate(new Date());
        POSTS.add(post2);

        Post post3=new Post() ;
        post3.setTitle("TECHNOLOGY");
        post3.setBody("IOS 14.5 is launched");
        post3.setDate(new Date());
        POSTS.add(post3);

        Post post4=new Post() ;
        post4.setTitle("NATIONAL");
        post4.setBody("Tesla is launching its factory in Telangana");
        post4.setDate(new Date());
        POSTS.add(post4);


    }
    public ArrayList<Post> getAllPosts() {
        return POSTS;
    }

    public void createPost(Post newPost) {
    POSTS.add(newPost);
    }
}
