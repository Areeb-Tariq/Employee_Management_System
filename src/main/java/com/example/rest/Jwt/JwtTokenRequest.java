package com.example.rest.Jwt;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcmVlYiIsImV4cCI6MTY1OTUwNjczMiwiaWF0IjoxNjU4OTAxOTMyfQ.tLRwHeUqN4tmKBiUXnU-OwykMPhNqcCZmRZFFonjXpJ_Q0m7QXeC-pfli1asddChr7x2aCb6c6_lRBHTAtKpKA"
//    }

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
