package com.example.newdemo.mapper;

import com.example.newdemo.model.Codes;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CodesMapper {
    @Insert({"insert into codes(username, code) values(#{username}, #{code})"})
    void addCode(Codes c);

    @Delete("delete from codes where username=#{username}")
    void delCode(@Param("username") String username);

    @Update("update codes set code = #{code} where username = #{username}")
    void updateCode(@Param("code") String code, @Param("username") String username);

    @Select("select * from codes")
    List<Codes> getCode();
}
