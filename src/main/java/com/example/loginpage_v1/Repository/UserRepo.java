package com.example.loginpage_v1.Repository;

import com.example.loginpage_v1.Model.UserDts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDts,Integer> {
    public boolean existsByEmail(String email);

    public UserDts findByEmail(String email);
}
