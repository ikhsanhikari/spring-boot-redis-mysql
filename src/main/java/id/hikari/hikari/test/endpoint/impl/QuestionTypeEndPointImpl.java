package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.dao.QuestionTypeDAO;
import id.hikari.hikari.test.data.model.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/question_types")
@RestController
public class QuestionTypeEndPointImpl  extends BaseEndPointImpl<QuestionType,Integer> {

    @Autowired
    private QuestionTypeDAO lovQuestionLevel;

    @GetMapping("/lov")
    ResponseEntity lov(){
        return ResponseEntity.ok(lovQuestionLevel.lovQuestionType());
    }

}
