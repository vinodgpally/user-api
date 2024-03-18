package com.digicertasmt.userapi.repository;

import com.digicertasmt.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
