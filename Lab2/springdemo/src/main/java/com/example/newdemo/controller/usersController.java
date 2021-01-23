package com.example.newdemo.controller;

import java.util.List;



import com.example.newdemo.model.Users;
import com.example.newdemo.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class usersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Users> UserQry() {
        // response.addHeader("Access-Control-Allow-Origin", "*");
        return usersService.getUser();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void userAdd(Users u) {
        usersService.addUser(u);
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void userUpdate(Users u) {
        usersService.updateUser(u);
    }

    @RequestMapping(value="/users", method=RequestMethod.DELETE)
    public void userDel(@RequestParam(value="username") String username) {
        usersService.delUser(username);
    }

    // public String home() {
    //     return "nihao";
    // }
}
