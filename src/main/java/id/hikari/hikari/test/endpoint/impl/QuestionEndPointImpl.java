package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.data.dto.request.RequestQuestionDTO;
import id.hikari.hikari.test.endpoint.QuestionEndPoint;
import id.hikari.hikari.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionEndPointImpl implements QuestionEndPoint {

    @Autowired
    QuestionService questionService;

    @Override
    public ResponseEntity save(@RequestBody RequestQuestionDTO questionDTO) {
        questionService.save(questionDTO);
        return ResponseEntity.ok("Success Saving question");
    }

    @Override
    public ResponseEntity selectAll() {
        return ResponseEntity.ok(questionService.select());
    }

    @Override
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        try {
            String idInt = String.valueOf(id);
            return ResponseEntity.ok(questionService.get(idInt));
        } catch (Exception e) {
            System.out.println("Question not found");
            return  ResponseEntity.badRequest().body("Not Found Question");
        }
    }
}
