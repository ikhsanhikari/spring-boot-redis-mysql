package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.dao.AnswerDAO;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import id.hikari.hikari.test.data.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/answers")
@RestController
public class AnswerEndPointImpl extends BaseEndPointImpl<Answer,Integer> {

    @Autowired
    private AnswerDAO answerDAO;


    @GetMapping("/question/{questionId}")
    public ResponseEntity answerQuestion(@PathVariable("questionId") Integer questionId){
        List<Answer> answers = answerDAO.findAnswerByQuestion(questionId);
        return ResponseEntity.ok(new JsonWrapper(0,"readAll data ", HttpStatus.OK,answers));
    }

}
