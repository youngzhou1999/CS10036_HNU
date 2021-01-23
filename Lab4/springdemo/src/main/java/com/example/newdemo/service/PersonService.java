package com.example.newdemo.service;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.newdemo.model.Person;

public interface PersonService {
    
    void addPerson(Person p);

    void delPerson(@Param("username") String username);

    void updatePerson(Person p);

    List<Person> getPerson();


    // void addUser(Users u);

    // void delUser(@Param("username") String username);

    // // public void groupDelete(String username);

    // void updateUser(Users u);

    // List<Users> getUser();

    // // public List<Users> out();
}
