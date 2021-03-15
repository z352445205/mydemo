package com.example.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author Zhengyn
 * @description
 * @create 21/1/18 17:57
 */
public class JwtUtil {
    private static String SIGNATURE = "!EQ2QRFSETEWATWYEW4535W5T2T4";

    public static String creatToken(Map<String, String> map) {

        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 1);
        final JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SIGNATURE));
    }

    public static DecodedJWT getTokenMsg(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
