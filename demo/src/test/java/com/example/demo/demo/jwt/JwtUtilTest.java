package com.example.demo.demo.jwt;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.jwt.JwtUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zhengyn
 * @description
 * @create 21/1/18 20:24
 */
class JwtUtilTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void creatToken() {
        final HashMap<String, String> map = new HashMap<>();
        map.put("userId","1111111");
        map.put("userName","zheng");
        final String s = JwtUtil.creatToken(map);
        System.err.println(s);
    }

    @Test
     void getTokenMsg() {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6InpoZW5nIiwiZXhwIjoxNjEwOTc2OTY2LCJ1c2VySWQiOiIxMTExMTExIn0.ra6TcV2_L6BfCl3RsZbY1VKEgcE0Mq7l7-Hm4iW6DrE\n";
        final DecodedJWT tokenMsg = JwtUtil.getTokenMsg(token);
        System.err.println(tokenMsg.getClaim("userId").asString());
        System.err.println(tokenMsg.getClaim("userName").asString());


    }
}