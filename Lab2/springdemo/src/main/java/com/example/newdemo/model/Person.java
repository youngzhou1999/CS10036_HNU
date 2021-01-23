package com.example.newdemo.model;

public class Person {
    private String username;
    private String name;
    private int age;
    private String teleno;

    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getTeleno() {
        return teleno;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setTeleno(String teleno) {
        this.teleno = teleno;
    }
    // public Person(String username, String name) {
    //     this.username = username;
    //     this.name = name;
    // }
    // public Person(String username, String name, int age) {
    //     this.username = username;
    //     this.name = name;
    //     this.age = age;
    // }
    // public Person(String username, String name, int age, String teleno) {
    //     this.username = username;
    //     this.name = name;
    //     this.age = age;
    //     this.teleno = teleno;
    // }
    // @Override
    // public String toString() {
    //     return String.format("%-12s", username) + "\t" + String.format("%-8s", name) + "\t" + String.format("%-15s", String.valueOf(age)) + "\t" + teleno;
    // }
}
