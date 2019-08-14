package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDAO extends JpaRepository<Question,Integer> {
}
