package id.hikari.hikari.test.endpoint;

import id.hikari.hikari.test.data.dto.request.RequestQuestionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/questions")
public interface QuestionEndPoint {

    @PostMapping("")
    ResponseEntity save(RequestQuestionDTO questionDTO);

    @GetMapping("")
    ResponseEntity selectAll();

    @GetMapping("/{id}")
    ResponseEntity getById(Integer id);

    @GetMapping("/rand")
    ResponseEntity selectByRand(@RequestParam("limit") Integer limit);
}
