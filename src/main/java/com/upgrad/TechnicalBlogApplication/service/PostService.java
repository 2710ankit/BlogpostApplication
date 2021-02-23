package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class PostService {
      //singleton
    private static ArrayList<Post> POSTS=new ArrayList<>();

//    static {
//        Post post1=new Post() ;
//        post1.setTitle("NEWS");
//        post1.setBody("Earthquake in delhi,punjab,hp");
//        post1.setDate(new Date());
//        POSTS.add(post1);
//
//        Post post2=new Post() ;
//        post2.setTitle("MUSIC");
//        post2.setBody("Selena Gomez is going to launch her spanish album");
//        post2.setDate(new Date());
//        POSTS.add(post2);
//
//        Post post3=new Post() ;
//        post3.setTitle("TECHNOLOGY");
//        post3.setBody("IOS 14.5 is launched");
//        post3.setDate(new Date());
//        POSTS.add(post3);
//
//        Post post4=new Post() ;
//        post4.setTitle("NATIONAL");
//        post4.setBody("Tesla is launching its factory in Telangana");
//        post4.setDate(new Date());
//        POSTS.add(post4);
//
//
//    }

    private final String url= "jdbc:postgresql://localhost:5432/technicalblog";
    private final String username="postgres";
    private final String password="asdasdasd";

    public Connection connect() throws SQLException {
       return DriverManager.getConnection(url,username,password);
    }



    public ArrayList<Post> getAllPosts() {
        try{
            //Step 1 ;- connect to DB
             Connection connection= connect();

             //Step 2:- GET/CREATE statement
            Statement statement=connection.createStatement();

            //Step 3:-Execute the select query
           ResultSet resultSet= statement.executeQuery("SELECT * FROM posts");

           // Step 4:- loop into the resultset and get the data
            while(resultSet.next()){
                Post post1= new Post();
                post1.setBody(resultSet.getString("body"));
                post1.setTitle(resultSet.getString("title"));
                post1.setDate(resultSet.getDate("Date"));

                //store the data in singleton
                POSTS.add(post1);


            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());

        }

        return POSTS;
    }

    public void createPost(Post newPost) {

        String query = "INSERT INTO posts(title,body,date) VALUES(?,?,?)";
        try{
        //Step 1 ;- connect to DB
        Connection connection= connect();

        //Step 2:- prepare a statement
            PreparedStatement preparedStatement= connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

        //Step 3 :- Fix the values from the VIEW
           preparedStatement.setString(1, newPost.getTitle());
            preparedStatement.setString(2, newPost.getBody());
            preparedStatement.setDate(3, new Date(newPost.getDate().getTime()));

           int updatedRows= preparedStatement.executeUpdate();
           if(updatedRows >0){
               System.out.println("Update is working fine");
           }

    }
    catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }
}
