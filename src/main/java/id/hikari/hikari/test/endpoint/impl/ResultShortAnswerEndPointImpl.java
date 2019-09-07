package id.hikari.hikari.test.endpoint.impl;


import id.hikari.hikari.test.dao.QuestionAnswerDAO;
import id.hikari.hikari.test.dao.ResultShortAnswerDAO;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import id.hikari.hikari.test.data.dto.response.ResponseResultShortAnswer;
import id.hikari.hikari.test.data.model.ResultShortAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("result_short_answer")
public class ResultShortAnswerEndPointImpl {

    @Autowired
    private ResultShortAnswerDAO resultShortAnswerDAO;

    @Autowired
    private QuestionAnswerDAO questionAnswerDAO;

    @PostMapping("")
    public ResponseEntity saveShortAnswer(@RequestBody  List<ResultShortAnswer> resultShortAnswers){
        resultShortAnswerDAO.saveAll(resultShortAnswers);
        return ResponseEntity.ok(new JsonWrapper(0,"save", HttpStatus.OK,resultShortAnswers));
    }

    @GetMapping("")
    public ResponseEntity resultShortAnswer(@RequestParam("packageUnique") String packageUnique){
        List <ResponseResultShortAnswer> responseResultShortAnswers = questionAnswerDAO.getResultShortAnswer(packageUnique);
        return ResponseEntity.ok(new JsonWrapper(0,"readAll data ",HttpStatus.OK,responseResultShortAnswers));
    }
}
