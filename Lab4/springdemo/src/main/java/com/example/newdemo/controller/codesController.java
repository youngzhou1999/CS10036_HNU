package com.example.newdemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.newdemo.model.Codes;
import com.example.newdemo.model.Person;
import com.example.newdemo.model.Users;
import com.example.newdemo.service.PersonService;
import com.example.newdemo.service.PhoneService;
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
@RequestMapping("/codes")
@CrossOrigin
public class codesController {

    @Autowired
    private PhoneService phoneService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PersonService PersonService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void sendCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        
        String username = request.getParameter("username");
        String teleno = request.getParameter("teleno");
        
        String code = vcode();
        String msg = new String();
        
        Person person = null;

        List<Person> personlist = PersonService.getPerson();
        for(int i=0; i<personlist.size(); i++) {
            Person p = personlist.get(i);
            if(p.getUsername().equals(username)) {
                person = p;
            }
        }

        if (person == null || person.getTeleno() == null || !person.getTeleno().equals(teleno)) {
			msg = "用户名与号码不匹配";
		} else {
			msg = phoneService.sendMessage(code, teleno);
			if (msg.equals("获取验证码成功")) {
                List<Codes> codelist = phoneService.getCode();
                boolean f = false;
                for(int i=0; i<codelist.size(); i++) {
                    if(codelist.get(i).getUsername().equals(username)) {
                        f = true;
                    }
                }
                if(!f)
                    phoneService.addCode(new Codes(username, code));
                else
                    phoneService.updateCode(new Codes(username, code));
			}
		}
        JSONObject jsonObject = new JSONObject(); // 创建Json对象
        jsonObject.put("msg", msg);
        response.getWriter().write(jsonObject.toString());

    }     
    public static String vcode() {
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
    }
    
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public void checkNode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        String username = request.getParameter("username");
		String code = request.getParameter("code");
        String pass = request.getParameter("password");
        
        List<Codes> codelist = phoneService.getCode();
        boolean f = false;
        for(int i=0; i<codelist.size(); i++) {
            Codes c = codelist.get(i);
            if(c.getUsername().equals(username) && c.getCode().equals(code)) {
                f = true;
            }
        }
        if(f) {
            usersService.updateUser(new Users(username, pass));
            phoneService.delCode(username);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", f);
		response.getWriter().write(jsonObject.toString());
    }




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
