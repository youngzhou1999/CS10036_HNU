package com.example.newdemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.newdemo.model.Users;
import com.example.newdemo.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class usersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/qry", method = RequestMethod.GET)
    public void UserQry(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // response.addHeader("Access-Control-Allow-Origin", "*");
        List<Users> userlist =  usersService.getUser();

        response.setContentType("application/json; charset=utf-8");
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");

        JSONObject jsonObject = new JSONObject();
        boolean f = false;
        for(int i=0; i<userlist.size(); i++) {
            Users u = userlist.get(i);
            if(u.getUsername().equals(username) && u.getPass().equals(pass)) {
                f = true;
            }
        }
        if(f) {
            jsonObject.put("state", true);
        }
        else 
            jsonObject.put("state", false);
        response.getWriter().write(jsonObject.toString());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void userAdd(Users u) {
        usersService.addUser(u);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void userUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8"); // 设置代码返回的编码格式

		String username = request.getParameter("username");
        String pass = request.getParameter("password");
        Users u = new Users(username, pass);
        usersService.updateUser(u);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", true);
		response.getWriter().write(jsonObject.toString());
    }

    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public void userDel(@RequestParam(value="username") String username) {
        usersService.delUser(username);
    }

    // public String home() {
    //     return "nihao";
    // }
}
