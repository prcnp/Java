package com.xianshuiyu.webshop.demos.web.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JwtUtils
{
    private static String signKey = "xianshuiyu";
    private static Long expire = 43200000L;

    /**
     * 生成jwt令牌
     * @param claims
     * @return
     */
    public static String generateJwt(Map<String, Object> claims)
    {
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt)
    {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
