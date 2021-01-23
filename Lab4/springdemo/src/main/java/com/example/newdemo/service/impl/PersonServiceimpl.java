package com.example.newdemo.service.impl;


import com.example.newdemo.mapper.PersonMapper;
import com.example.newdemo.model.Person;
import com.example.newdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PersonServiceimpl implements PersonService {
    
    
    @Autowired
    private PersonMapper personMapper;

    @Override
    public void addPerson(Person p) {
        personMapper.addPerson(p);
    }

    @Override
    public void delPerson(String username) {
        personMapper.delPerson(username);
    }

    @Override
    public void updatePerson(Person p) {
        personMapper.updatePerson(p.getUsername(), p.getName(), p.getAge(), p.getTeleno(), p.getUsername());
    }

    @Override
    public List<Person> getPerson() {
        List<Person> personlist = personMapper.getPerson();
        return personlist;
    }
    
    
    
    
    
    // private Connection conn;

    // public PersonDaoimpl(Connection conn) {
    //     if(this.conn == null)
    //         this.conn = conn;
    // }

    // public void insert(Person p) {
    //     String sql = "insert ignore person values(?,?,?,?)";

    //     try {
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, p.getUsername());
    //         pstmt.setString(2, p.getName());
    //         pstmt.setInt(3, p.getAge());
    //         pstmt.setString(4, p.getTeleno());
    //         pstmt.executeUpdate();
    //         pstmt.close();
    //     } catch (SQLException se) {
    //         se.printStackTrace();
    //     }
    // }

    // public void delete(String username) {
    //     String sql = "delete from person where username = ?";

    //     try {
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, username);
    //         pstmt.executeUpdate();
    //         pstmt.close();
    //     } catch (SQLException se) {
    //         se.printStackTrace();
    //     } 
    // }

    // public void groupDelete(String username) {
    //     String sql = "delete from person where username like ?";

    //     try {
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, username);
    //         pstmt.executeUpdate();
    //         pstmt.close();
    //     } catch (SQLException se) {
    //         se.printStackTrace();
    //     } 
    // }


    // public void update(Person p) {
    //     String sql = "update person set username = ?, name = ?, age = ?, teleno = ? where username = ?";
        
    //     try {
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, p.getUsername());
    //         pstmt.setString(2, p.getName());
    //         pstmt.setInt(3, p.getAge());
    //         pstmt.setString(4, p.getTeleno());
    //         pstmt.setString(5, p.getUsername());
    //         pstmt.executeUpdate();
    //         pstmt.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    // }

    // public List<Person> query(String username) {
    //     String sql = "select * from person";
    //     List<Person> ps = new ArrayList<>();
    //     try {
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(sql);
    //         while(rs.next()) {
    //             String usernamenow = rs.getString("username");
    //             String name = rs.getString("name");
    //             int age = rs.getInt("age");
    //             String teleno = rs.getString("teleno");
    //             if(username.equals(usernamenow))
    //                 ps.add(new Person(usernamenow, name, age, teleno));
    //         }
    //         rs.close();
    //         stmt.close();
    //     } catch (SQLException se) {
    //         se.printStackTrace();
    //     }

    //     return ps;
    // }

    // public List<Person> out() {
    //     String sql = "select * from person";
    //     List<Person> ps = new ArrayList<>();
    //     try {
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(sql);

    //         // System.out.println("表person");
    //         // System.out.println("字段名username" + "\t" + "字段名name" + "\t" + "字段名age" + "\t" + "字段名teleno");
    //         while(rs.next()) {
    //             String username = rs.getString("username");
    //             String name = rs.getString("name");
    //             int age = rs.getInt("age");
    //             String teleno = rs.getString("teleno");
    //             ps.add(new Person(username, name, age, teleno));
    //             // System.out.println(String.format("%-12s", username) + "\t" + String.format("%-8s", name) + "\t" + String.format("%-15s", String.valueOf(age)) + "\t" + teleno);
    //         }
    //         rs.close();
    //         stmt.close();
    //     } catch (SQLException se) {
    //         se.printStackTrace();
    //     }
    //     return ps;
    // }

}
