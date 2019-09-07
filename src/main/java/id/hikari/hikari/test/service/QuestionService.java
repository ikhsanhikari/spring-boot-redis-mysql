package id.hikari.hikari.test.service;

import id.hikari.hikari.test.data.dto.request.RequestQuestionDTO;
import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.data.dto.response.ResponseQuestionDTO;
import id.hikari.hikari.test.data.model.Question;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionService {
    void save(RequestQuestionDTO questionDTO);
    List<ResponseQuestionDTO> selectAll();
    ResponseQuestionDTO getById(Integer idQuestion) throws Exception;
    DataResponse select();
    DataResponse get(String id);
    DataResponse selectByRand(Integer limit);
}
