package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.dto.response.ResponseLovDTO;
import id.hikari.hikari.test.data.model.QuestionLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionLevelDAO extends JpaRepository<QuestionLevel,Integer> {

    @Query("select new id.hikari.hikari.test.data.dto.response.ResponseLovDTO(id,questionLevel) from QuestionLevel")
    List<ResponseLovDTO> lovQuestionLevel();
}
