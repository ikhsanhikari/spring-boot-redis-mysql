package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.ShortAnswer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShortAnswerDAO extends JpaRepository<ShortAnswer,Integer> {
    @Query("select q from ShortAnswer q order by rand()")
    List<ShortAnswer> findByRand(Pageable pageable);
}
