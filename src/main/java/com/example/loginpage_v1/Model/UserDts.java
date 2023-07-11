package com.example.loginpage_v1.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loginpage")
public class UserDts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullname;
    private String email;
    private String address;
    private String qualification;
    private String password;
    private String role;
}
