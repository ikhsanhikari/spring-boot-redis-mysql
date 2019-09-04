package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.dao.QuestionDAO;
import id.hikari.hikari.test.data.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/question-masters")
@RestController
public class QuestionMasterEndPointImpl extends BaseEndPointImpl<Question,Integer> {

    @Autowired
    private QuestionDAO  questionDAO;

    @GetMapping("/lov")
    ResponseEntity lov(){
        return ResponseEntity.ok(questionDAO.lovQuestion());
    }

}
