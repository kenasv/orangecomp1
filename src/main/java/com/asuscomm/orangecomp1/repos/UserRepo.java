package com.asuscomm.orangecomp1.repos;

import com.asuscomm.orangecomp1.allbd.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
