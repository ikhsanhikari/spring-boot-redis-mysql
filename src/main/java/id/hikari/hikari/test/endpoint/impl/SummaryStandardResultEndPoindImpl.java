package id.hikari.hikari.test.endpoint.impl;


import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.dao.QuestionAnswerDAO;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import id.hikari.hikari.test.data.model.SummaryStandardResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/summary_standard")
@RestController
public class SummaryStandardResultEndPoindImpl extends BaseEndPointImpl<SummaryStandardResult,Integer> {

    @Autowired
    private QuestionAnswerDAO questionAnswerDAO;

    @GetMapping("/list")
    public ResponseEntity getList(){
        return ResponseEntity.ok(new JsonWrapper(0,"readAll data ", HttpStatus.OK,questionAnswerDAO.getSummaryStandardResult()));
    }
}
