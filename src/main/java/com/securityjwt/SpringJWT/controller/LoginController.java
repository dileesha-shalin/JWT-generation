package com.securityjwt.SpringJWT.controller;

import com.securityjwt.SpringJWT.dto.LoginRequest;
import com.securityjwt.SpringJWT.dto.LoginResponse;
import com.securityjwt.SpringJWT.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authentication"})
        public LoginResponse createJwtTokenAndLogin(@RequestBody LoginRequest loginRequest) throws Exception{

        return jwtService.createJwtToken(loginRequest);

    }
}
