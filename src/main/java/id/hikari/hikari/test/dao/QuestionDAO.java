package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.dto.response.ResponseLovDTO;
import id.hikari.hikari.test.data.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question,Integer> {
    @Query("select new id.hikari.hikari.test.data.dto.response.ResponseLovDTO(id,question) from Question")
    List<ResponseLovDTO> lovQuestion();


    @Query("select q from Question q order by rand()")
    List<Question> findByRand(Pageable pageable);
}
