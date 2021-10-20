package com.example.filter;

import com.example.filter.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestJWT {
    public static void main(String[] args) {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", "1");
        map.put("userName", "zhangsan");
        //创建token
        final String token = JwtUtil.createToken("1", "aud", new Date().toString(), "MaiKeBai", map);
        System.out.println("token = " + token);



        Jws<Claims> claimsJws = JwtUtil.parseToken(token);
        Claims body = claimsJws.getBody();
        Set<String> strings = body.keySet();
        for (String s : strings) {
            System.out.println("--->"+s);
        }
        Object userId = body.get("userId");
        System.out.println(userId.toString());

    }
}
