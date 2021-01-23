package com.example.newdemo.service;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.newdemo.model.Codes;

public interface PhoneService {
    void addCode(Codes c);

    void delCode(@Param("username") String username);

    // public void groupDelete(String username);

    void updateCode(Codes c);

    List<Codes> getCode();

    String sendMessage(String code, String mobile);
}
