package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {
}
