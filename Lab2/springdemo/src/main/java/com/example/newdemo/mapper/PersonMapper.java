package com.example.newdemo.mapper;

import com.example.newdemo.model.Person;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    @Insert({"insert into person(username, name, age, teleno) values(#{username}, #{name}, #{age}, #{teleno})"})
    void addPerson(Person p);

    @Delete("delete from person where username=#{username}")
    void delPerson(@Param("username") String username);

    @Update("update person set username = #{newusername}, name = #{name}, age = #{age}, teleno = #{teleno} where username = #{username}")
    void updatePerson(@Param("newusername") String newusername, @Param("name") String name, @Param("age") int age, @Param("teleno") String teleno, @Param("username") String username);

    @Select("select * from person")
    List<Person> getPerson();
}
