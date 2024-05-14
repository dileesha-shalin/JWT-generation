package com.securityjwt.SpringJWT.service;

import com.securityjwt.SpringJWT.entity.Role;
import com.securityjwt.SpringJWT.entity.User;
import com.securityjwt.SpringJWT.repo.RoleRepo;
import com.securityjwt.SpringJWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerNewUser(User user) {

        return userRepo.save(user);

    }

    public void initRoleAndUser() {
        Role adminRole = new Role();
        Role userRole = new Role();
        if (!roleRepo.existsById("Admin")) {
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin Role");
            roleRepo.save(adminRole);
        }

        if (!roleRepo.existsById("User")) {

            userRole.setRoleName("User");
            userRole.setRoleDescription("UserRole");
            roleRepo.save(userRole);
        }

        if(!userRepo.existsById("admin123")) {
            User user = new User();
            user.setUserName("admin123");
            user.setUserPassword(getEncodedPassword("1234"));
            user.setUserFirstName("shalin");
            user.setUserLastName("Dileesha");

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);

            user.setRole(adminRoles);
            userRepo.save(user);
        }

        if(!userRepo.existsById("user123")) {
            User user = new User();
            user.setUserName("user123");
            user.setUserPassword(getEncodedPassword("5678"));
            user.setUserFirstName("shameen");
            user.setUserLastName("Dilusha");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(adminRole);

            user.setRole(userRoles);
            userRepo.save(user);
        }

    }
    public  String getEncodedPassword(String password){

        return passwordEncoder.encode(password);
    }
}
