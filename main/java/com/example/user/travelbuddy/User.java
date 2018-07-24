package com.example.user.travelbuddy;

public class User {

    String uname;
    String pswd;

    public User(){
    }

    public User(String username,String password){
        this.uname=username;
        this.pswd=password;
    }

    public String getUsername() {
        return uname;
    }

    public void setUsername(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return pswd;
    }

    public void setPassword(String pswd) {
        this.pswd = pswd;
    }
}