package com.securityjwt.SpringJWT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {

    private String username;
    private String userPassword;
}
