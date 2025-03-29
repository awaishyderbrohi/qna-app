package com.techfira.service;

import com.techfira.dto.UserReqDTO;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.mapstruct.ap.internal.writer.FreeMarkerWritable;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;

@Service
public class JwtService {

    private String secretKey;

//    Token Generator
    public String generateToken(UserReqDTO userReqDTO) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(userReqDTO.getUserName())
                .issuer("QNA")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*10*1000))
                .and()
                .signWith(generateKey())
                .compact();

    }

//    SecretKey Generator
    private SecretKey generateKey() {
        byte[] decoded = Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decoded);
    }

//  Getter for SecretKey
    private String getSecretKey(){
        return secretKey = "c0bf29212faf5c77a8b0464d8178b8491a08163b7c0169d204b11be978d2ca7b6500f6ce7ca90b925097477f6a39bb9950336f68654c3db6d7ccf5b2ff7828212881b1fa84421d8fe32aa47b99023b940e56c4222d6b8df208466a690e97cd1b054ba5febbb4dc2e0ef34b83e9164f55beb89ab5fcf8cb236e9b7773f777880a008ee90734bd93b7d8396b50db2dbf4bfb58ea1d641e68cb5f3ac09222c66e4f87c227b3d640016ae1bcdcc1657a02c1bfc9bdecaa0a1ef69269d1dec57eaa0937b835594aaa1d368a01ae5a1cd5e1d0b8bd8eb1fd1d659a5a79bfc0ccd3c9f8e79e0660b6cf694fa63ae2fe8dd18d18ba9f1d82025bb1c52e03ca4ff52c5c74";
    }


    public String extractUserName() {
        return "";
    }


    public boolean isTokenValid(String jwt, UserDetails userDetails) {

        return false;
    }
}
