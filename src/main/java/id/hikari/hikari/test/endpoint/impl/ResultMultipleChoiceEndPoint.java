package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.dao.QuestionAnswerDAO;
import id.hikari.hikari.test.dao.ResultmultipleChoiceDAO;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import id.hikari.hikari.test.data.dto.response.ResponseMultipleResultAll;
import id.hikari.hikari.test.data.model.ResultMultipleChoice;
import id.hikari.hikari.test.data.sttaic.GeneralStatic;
import id.hikari.hikari.test.service.ResultMultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result_multiple_choice")
public class ResultMultipleChoiceEndPoint {

    @Autowired
    private ResultmultipleChoiceDAO resultmultipleChoiceDAO;

    @Autowired
    private ResultMultipleService resultMultipleService;

    @Autowired
    private QuestionAnswerDAO  questionAnswerDAO;


    @PostMapping("")
    public ResponseEntity saveAllResult(@RequestBody List<ResultMultipleChoice> multipleChoices){
        String staticNumber = GeneralStatic.randomAlphaNumeric(6);
        for (ResultMultipleChoice choice: multipleChoices) {
            choice.setPackageUnique(staticNumber);
            if(choice.getIdAnswer()==null){
                choice.setIdAnswer(0);
            }
        }
        resultmultipleChoiceDAO.saveAll(multipleChoices);
        return ResponseEntity.ok(new JsonWrapper(0,"save", HttpStatus.OK,staticNumber));
    }

    @GetMapping("/find_answer/{package}")
    public ResponseEntity findAnswer(@PathVariable("package" ) String packageUnique){
        return resultMultipleService.getResultMultiple(packageUnique);
    }

    @GetMapping("")
    public ResponseEntity getResultMultipleAll(@RequestParam("packageUnique") String packageUnique){
        List<ResponseMultipleResultAll> responseMultipleResultAlls = questionAnswerDAO.getResultMultipleAll(packageUnique);
        return ResponseEntity.ok(new JsonWrapper(0,"readAll data ",HttpStatus.OK,responseMultipleResultAlls));
    }
}
