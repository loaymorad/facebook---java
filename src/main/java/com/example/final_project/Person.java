
package com.example.final_project;




import java.util.ArrayList;


public class Person {


    protected String name =new String() ;
    protected int id ;
    protected String d_date=new String() ;
    protected String m_date=new String();
    protected String y_date=new String();
    protected String gender=new String() ;
    protected String email =new String();
    protected String password =new String();

    // Here its all posts and all its replies  for same person
    protected ArrayList <String> posts_comments_likes = new ArrayList <> ();
    protected ArrayList <Integer> user_friends =new ArrayList<>();




    public Person(ArrayList <String> posts_comments_likes, String name, int id, String d_date,String m_date,String y_date, String gender, String email, String password, ArrayList <Integer> user_friends) {
        this.posts_comments_likes = posts_comments_likes;
        this.name = name;
        this.id = id;
        this.d_date = d_date;
        this.m_date=m_date;
        this.y_date=y_date;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.user_friends=user_friends;
    }
    public Person(Person p1) {
        this.posts_comments_likes = p1.posts_comments_likes;
        this.name = p1.name;
        this.id = p1.id;
        this.d_date = p1.d_date;
        this.m_date=p1.m_date;
        this.y_date=p1.y_date;
        this.gender = p1.gender;
        this.email = p1.email;
        this.password = p1.password;
        this.user_friends=p1.user_friends;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.d_date = d_date;
    }

    public void setM_date(String m_date) {this.m_date = m_date;}

    public void setY_date(String y_date) {this.y_date = y_date;}

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosts_comments_likes(ArrayList<String> posts_comments_likes) {
        this.posts_comments_likes = posts_comments_likes;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getD_date() {return d_date;}

    public String getM_date() {return m_date;}

    public String getY_date() {return y_date;}

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getPosts_comments_likes() {
        return posts_comments_likes;
    }

    public ArrayList<Integer> getUser_friends(){
        return user_friends;
    }

    public void setUser_friends(ArrayList<Integer> user_friends) {
        this.user_friends=user_friends;
    }









}
