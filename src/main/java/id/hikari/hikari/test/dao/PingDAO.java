package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.Ping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PingDAO extends JpaRepository<Ping,Long> {
}
