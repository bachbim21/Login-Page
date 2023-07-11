package com.example.loginpage_v1.Service;

import com.example.loginpage_v1.Model.UserDts;
import com.example.loginpage_v1.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public UserDts createUser(UserDts userDts){
        userDts.setPassword(passwordEncoder.encode(userDts.getPassword()));
        userDts.setRole("ROLE_USER");
        return userRepo.save(userDts);
    }

    public boolean checkEmail(String email){
        return userRepo.existsByEmail(email);
    }

}
