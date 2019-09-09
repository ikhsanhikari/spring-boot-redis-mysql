package id.hikari.hikari.test.dao;

import id.hikari.hikari.test.data.dto.response.ResponseMultipleResult;
import id.hikari.hikari.test.data.dto.response.ResponseMultipleResultAll;
import id.hikari.hikari.test.data.dto.response.ResponseResultShortAnswer;
import id.hikari.hikari.test.data.dto.response.ResponseSummaryStandardResult;
import id.hikari.hikari.test.data.model.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionAnswerDAO extends JpaRepository<QuestionAnswer,Integer> {

    @Query(nativeQuery = true)
    List<ResponseMultipleResult> getResultMultiple(String packageUnique);

    @Query(nativeQuery = true)
    List<ResponseResultShortAnswer> getResultShortAnswer(String packageUnique);

    @Query(nativeQuery =true)
    List<ResponseMultipleResultAll> getResultMultipleAll(String packageUnique);

    @Query(nativeQuery = true)
    List<ResponseSummaryStandardResult> getSummaryStandardResult();
}

