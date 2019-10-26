package org.sid.jwtspringsecurity.dao;

import org.sid.jwtspringsecurity.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}
