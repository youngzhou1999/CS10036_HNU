package com.example.newdemo.service.impl;

import com.example.newdemo.model.aliyun.*;
import com.example.newdemo.mapper.CodesMapper;
import com.example.newdemo.model.Codes;
import com.example.newdemo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
// import java.util.Collections;

@Service
public class PhoneServiceimpl implements PhoneService {
    @Autowired
    private CodesMapper codesMapper;

    @Override
    public void addCode(Codes c) {
        codesMapper.addCode(c);
    }

    @Override
    public void delCode(String username) {
        codesMapper.delCode(username);
    }

    @Override
    public void updateCode(Codes c) {
        codesMapper.updateCode(c.getCode(), c.getUsername());
    }

    @Override
    public List<Codes> getCode(){
        List<Codes> codelist = codesMapper.getCode();
        return codelist;
    }

    public String sendMessage(String code, String mobile) {
		// String state = PhoneCode.getPhonemsg(code, mobile);
        // return state;
        String Uid = "kmzyhnu";
        String Key = "d41d8cd98f00b204e980";
        String sendPhoneNum = mobile;
        String desc = "验证码为：" + code;
        int res = SMS.send(Uid, Key, sendPhoneNum, desc);
        if(res == 1) {
            return "获取验证码成功";
        }else {
            return "由于系统维护，暂时无法注册";
        }
	}


    // public void delete(String username) {
    //     // String sql = "delete from users where username = ?";
    //     // try {
    //     //     PreparedStatement pstmt = conn.prepareStatement(sql);
    //     //     pstmt.setString(1, username);
    //     //     pstmt.executeUpdate();
    //     //     pstmt.close();
    //     // } catch (SQLException se) {
    //     //     se.printStackTrace();
    //     // }
    // }

    // public void groupDelete(String username) {
    //     // String sql = "delete from users where username like ?";
    //     // try {
    //     //     PreparedStatement pstmt = conn.prepareStatement(sql);
    //     //     pstmt.setString(1, username);
    //     //     pstmt.executeUpdate();
    //     //     pstmt.close();
    //     // } catch (SQLException se) {
    //     //     se.printStackTrace();
    //     // }
    // }

    // public void update(Users u) {
    //     // String sql = "update users set username = ?, pass = ?, where username = ?";
        
    //     // try {
    //     //     PreparedStatement pstmt = conn.prepareStatement(sql);
    //     //     pstmt.setString(1, u.getUsername());
    //     //     pstmt.setString(2, u.getPass());
    //     //     pstmt.setString(3, u.getUsername());
    //     //     pstmt.executeUpdate();
    //     //     pstmt.close();
    //     // } catch (SQLException e) {
    //     //     e.printStackTrace();
    //     // }
    // }

    // public List<Users> query(String username) {

    //     // String sql = "select * from users";
    //     // List<Users> us = new ArrayList<>();
    //     // try {
    //     //     Statement stmt = conn.createStatement();
    //     //     ResultSet rs = stmt.executeQuery(sql);
    //     //     while(rs.next()) {
    //     //         String usernamenow = rs.getString("username");
    //     //         String pass = rs.getString("pass");
    //     //         if(username.equals(usernamenow))
    //     //             us.add(new Users(usernamenow, pass));
    //     //     }
    //     //     rs.close();
    //     //     stmt.close();
    //     // } catch (SQLException se) {
    //     //     se.printStackTrace();
    //     // }

    //     // return us;
    // }

    // public List<Users> out() {
    //     // String sql = "select username, pass from users";
    //     // List<Users> us = new ArrayList<>();
    //     // try {
    //     //     Statement stmt = conn.createStatement();
    //     //     ResultSet rs = stmt.executeQuery(sql);

    //     //     // System.out.println("表users");
    //     //     // System.out.println("字段名username" + "\t" + "字段名pass");
    //     //     while(rs.next()) {
    //     //         String username = rs.getString("username");
    //     //         String pass = rs.getString("pass");
    //     //         us.add(new Users(username, pass));
    //     //         // System.out.println(String.format("%-12s", username) + "\t" + pass);   
    //     //     }
    //     //     rs.close();
    //     //     stmt.close();
    //     // } catch (SQLException se) {
    //     //     se.printStackTrace();
    //     // }
    //     // return us;
    // }
 
}
