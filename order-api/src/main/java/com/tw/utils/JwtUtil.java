package com.tw.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {


    private static final String CLAIM_KEY_USER_ID = "sub";
    private static final String CLAIM_KEY_ROLE = "role";
    private static final String CLAIM_KEY_CREATED = "created";

   @Value("${jwt.secret}")
    private String secret; //秘钥

  @Value("${jwt.expiration}")
    private Long expiration; //过期时间

    /**
     * 从token中获取用户account
     * @param token
     * @return
     */
    public boolean validateToken(String token) {

        try {
            final Claims claims = getClaimsFromToken(token);
            final String useraccount = claims.getSubject();
            final Date expiration= claims.getExpiration();
            Boolean result= expiration.after(new Date());
            return result;
        } catch (Exception e) {
            return false;
        }
    }
    public Claims getTokenClaims(String token) {

        try {
             Claims claims = getClaimsFromToken(token);
            final Date expiration= claims.getExpiration();
            Boolean result= expiration.after(new Date());
            if(result) {
                return claims;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 从token中获取创建时间
     * @param token
     * @return
     */
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    /**
     * 获取token的过期时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * 从token中获取claims
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生存token的过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        Boolean result= expiration.before(new Date());
        return result;
    }



    /**
     * 生成token
     * @param userDetails
     * @return
     */
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(CLAIM_KEY_USER_ACCOUNT, userDetails.getUsername());
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }

    /**
     * 生成token
     * @param userId
     * @return
     */
    public String generateToken(String userId,String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USER_ID, userId);
        claims.put(CLAIM_KEY_ROLE,role);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * token 是否可刷新
     * @param token
     * @return
     */
    public Boolean canTokenBeRefreshed(String token) {
        final Date created = getCreatedDateFromToken(token);
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

//    /**
//     * 验证token
//     * @param token
//     * @param userDetails
//     * @return
////     */
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUser user = (JwtUser) userDetails;
//        final String useraccount = getUserAccountFromToken(token);
//        final Date created = getCreatedDateFromToken(token);
//        Boolean result= (
//                useraccount.equals(user.getUsername())
//                        && !isTokenExpired(token)
//        );
//        return result;
//    }
}
