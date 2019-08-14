package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerDAO extends JpaRepository<QuestionAnswer,Integer> {
}
