package com.example.newdemo.service.impl;

import com.example.newdemo.mapper.UsersMapper;
import com.example.newdemo.model.Users;
import com.example.newdemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
// import java.util.Collections;

@Service
public class UsersServiceimpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users u) {
        usersMapper.addUser(u);
    }

    @Override
    public void delUser(String username) {
        usersMapper.delUser(username);
    }

    @Override
    public void updateUser(Users u) {
        usersMapper.updateUser(u.getPass(), u.getUsername());
    }

    @Override
    public List<Users> getUser() {
        List<Users> userlist = usersMapper.getUser();
        return userlist;
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
