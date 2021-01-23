package com.example.newdemo.controller;

import java.util.List;


import com.example.newdemo.model.Person;
import com.example.newdemo.service.PersonService;

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
public class personController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/person", method = RequestMethod.GET)
    // @ResponseBody
    public List<Person> personQry() {
        // response.addHeader("Access-Control-Allow-Origin", "*");
        return personService.getPerson();
    }
    // HttpServletResponse response
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    // @ResponseBody
    public void personAdd(Person p) {
        personService.addPerson(p);
    }
    
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public void personUpdate(Person p) {
        personService.updatePerson(p);
    }

    @RequestMapping(value="/person", method=RequestMethod.DELETE)
    public void personDel(@RequestParam(value="username") String username) {
        personService.delPerson(username);
    }
    
    
}
