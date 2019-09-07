package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuestUserDAO extends JpaRepository<GuestUser,Integer> {
    @Query("select ug from GuestUser ug where username = ?1 or email = ?1 or phone = ?1")
    List<GuestUser> findByUsername(String username);
}
