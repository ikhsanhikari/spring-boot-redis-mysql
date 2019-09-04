package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.QuestionLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionLevelDAO extends JpaRepository<QuestionLevel,Integer> {
}
