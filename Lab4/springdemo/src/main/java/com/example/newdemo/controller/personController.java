package com.example.newdemo.controller;

//import java.io.Console;
import java.io.IOException;
import java.util.List;

import com.example.newdemo.model.Person;
import com.example.newdemo.model.Users;
import com.example.newdemo.service.PersonService;
import com.example.newdemo.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class personController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/qry", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> personQry() {
        // response.addHeader("Access-Control-Allow-Origin", "*");
        return personService.getPerson();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public void personList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // response.addHeader("Access-Control-Allow-Origin", "*");
        // return personService.getPerson();
        response.setContentType("application/json; charset=utf-8");
        String username = request.getParameter("username");
        List<Person> personlist = personService.getPerson();
        Person person = null;
        for(int i=0; i<personlist.size(); i++) {
            Person p = personlist.get(i);
            if(p.getUsername().equals(username)) {
                person = p;
            }
        }
        String name = (person.getName() == null) ? "" : person.getName();
		String age = ((Integer)person.getAge() == null) ? "" : ((Integer)person.getAge()).toString();
        String teleno = (person.getTeleno() == null) ? "" : person.getTeleno();
        
        JSONObject jsonObject = new JSONObject(); // 创建Json对象
		jsonObject.put("name", name);
		jsonObject.put("age", age);
        jsonObject.put("teleno", teleno);
        response.getWriter().write(jsonObject.toString());
    }

    // HttpServletResponse response
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @ResponseBody
    public void personAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8"); // 设置代码返回的编码格式

		String username = request.getParameter("username");
		String name = request.getParameter("name");
        String ageString = request.getParameter("age");
        int age = 0;
        if(!ageString.isEmpty()) {
            age = Integer.valueOf(ageString);
        }
		String teleno = request.getParameter("teleno");
        String pass = request.getParameter("password");
        if(teleno.isEmpty()) {
            teleno = null;
        }
        
        Users user = new Users(username, pass);
        Person person = new Person(username, name, age, teleno);
        List<Users> userlist = usersService.getUser();
        boolean f = true;
        for(int i=0; i<userlist.size(); i++) {
            Users u = userlist.get(i);
            if(u.getUsername().equals(username)) {
                f = false;
            }
        }
        JSONObject jsonObject = new JSONObject();
        if(f) {
            usersService.addUser(user);
            personService.addPerson(person);
            jsonObject.put("state", true);
        }
        else {
            jsonObject.put("state", false);
        }
        response.getWriter().write(jsonObject.toString());
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void personUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8"); // 设置代码返回的编码格式

		String username = request.getParameter("username");
		String name = request.getParameter("name");
        String ageString = request.getParameter("age");
        int age = 0;
        if(ageString != null && !ageString.equals("")) {
            age = Integer.parseInt(ageString);
        }
        String teleno = request.getParameter("teleno");
        Person p = new Person(username, name, age, teleno);
        personService.updatePerson(p);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", true);
		response.getWriter().write(jsonObject.toString());
    }

    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public void personDel(@RequestParam(value="username") String username) {
        personService.delPerson(username);
    }
    
    
}
