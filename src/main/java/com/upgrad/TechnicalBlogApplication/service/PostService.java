package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import com.upgrad.TechnicalBlogApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    // Using JPA
    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPosts() {

            return postRepository.getAllPost();


    }




    public void createPost(Post newPost) {
        postRepository.createPost(newPost);
    }

    public void deletePost(Integer postId){
        postRepository.deletePost(postId);
    }
}
