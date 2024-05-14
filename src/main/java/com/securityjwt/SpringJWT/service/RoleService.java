package com.securityjwt.SpringJWT.service;


import com.securityjwt.SpringJWT.entity.Role;
import com.securityjwt.SpringJWT.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}
