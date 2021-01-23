package com.example.newdemo.model;

public class Users {
    private String username;
    private String pass;

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    // public Users(String username, String pass) {
    //     this.username = username;
    //     this.pass = pass;
    // }
    // @Override
    // public String toString(){
    //     return String.format("%-12s", username) + "\t" + pass; 
    // }
}
