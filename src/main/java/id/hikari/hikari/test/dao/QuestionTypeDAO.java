package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.dto.response.ResponseLovDTO;
import id.hikari.hikari.test.data.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionTypeDAO extends JpaRepository<QuestionType,Integer> {
    @Query("select new id.hikari.hikari.test.data.dto.response.ResponseLovDTO(id,questionType) from QuestionType")
    List<ResponseLovDTO> lovQuestionType();
}
