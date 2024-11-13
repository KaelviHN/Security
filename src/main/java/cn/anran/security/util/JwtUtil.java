package cn.anran.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Map;

/**
 * @author: KaelviHN
 * @created: 2024/11/13
 * @description:
 **/
@Component
public class JwtUtil {
    private static final String secret = "a1a7a7361a4b47baa33a724d6d067c30";

    /**
     * 生成token
     * @return
     */
    public String createToken(Map<String, Object> claims) {
        Date now = new Date(System.currentTimeMillis());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 1000 * 60 * 30))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 解析Token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
