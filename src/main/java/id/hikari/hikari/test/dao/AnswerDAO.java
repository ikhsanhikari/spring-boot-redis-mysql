package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerDAO extends JpaRepository<Answer,Integer> {
    @Query("SELECT a FROM Answer a WHERE a.idQuestion = ?1 ")
    List<Answer> findAnswerByQuestion(Integer questionId);

    @Query("SELECT a FROM Answer a WHERE a.idQuestion = ?1 ")
    List<Answer> findAnswerByQuestionString(String questionId);
}
