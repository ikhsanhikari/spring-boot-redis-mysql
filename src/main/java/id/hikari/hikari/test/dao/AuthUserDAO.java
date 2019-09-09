package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserDAO extends JpaRepository<AuthUser,Long> {
    AuthUser findByUsername(String username);
}
