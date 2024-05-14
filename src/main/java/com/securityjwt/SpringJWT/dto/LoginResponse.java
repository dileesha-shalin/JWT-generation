package com.securityjwt.SpringJWT.dto;

import com.securityjwt.SpringJWT.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {
    private User user;
    private String jwtToken;
}
