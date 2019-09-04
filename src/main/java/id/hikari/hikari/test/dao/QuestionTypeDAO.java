package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeDAO extends JpaRepository<QuestionType,Integer> {
}
