package com.example.newdemo.mapper;

import com.example.newdemo.model.Users;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Insert({"insert into users(username, pass) values(#{username}, #{pass})"})
    void addUser(Users user);

    @Delete("delete from users where username=#{username}")
    void delUser(@Param("username") String username);

    @Update("update users set pass = #{pass} where username = #{username}")
    void updateUser(@Param("pass") String pass, @Param("username") String username);

    @Select("select * from users")
    List<Users> getUser();
}
