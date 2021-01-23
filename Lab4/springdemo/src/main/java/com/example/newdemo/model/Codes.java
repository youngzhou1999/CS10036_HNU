package com.example.newdemo.model;

public class Codes {
    private String username;
    private String code;

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    public Codes(String username, String code) {
        this.username = username;
        this.code = code;
    }
    
}
