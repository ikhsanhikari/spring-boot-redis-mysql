package id.hikari.hikari.test.endpoint.impl;


import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.dao.ShortAnswerDAO;
import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.data.model.ShortAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/short_answers")
public class ShortANswerEndPointImpl extends BaseEndPointImpl<ShortAnswer,Integer> {
    @Autowired
    private ShortAnswerDAO shortAnswerDAO;

    @GetMapping("/rand")
    public ResponseEntity selectRand(@RequestParam("limit") Integer limit){
        PageRequest pageRequest = new PageRequest(0,limit);
        List<ShortAnswer> shortAnswers = shortAnswerDAO.findByRand(pageRequest);
        return ResponseEntity.ok(new DataResponse("All Questions","Questions",shortAnswers));
    }
}
