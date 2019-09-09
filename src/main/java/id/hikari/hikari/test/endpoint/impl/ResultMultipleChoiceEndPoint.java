package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.dao.QuestionAnswerDAO;
import id.hikari.hikari.test.dao.ResultmultipleChoiceDAO;
import id.hikari.hikari.test.dao.SummaryStandardResultDAO;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import id.hikari.hikari.test.data.dto.response.ResponseMultipleResultAll;
import id.hikari.hikari.test.data.model.ResultMultipleChoice;
import id.hikari.hikari.test.data.model.SummaryStandardResult;
import id.hikari.hikari.test.data.sttaic.GeneralStatic;
import id.hikari.hikari.test.service.ResultMultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @Autowired
    private SummaryStandardResultDAO summaryStandardResultDAO;


    @PostMapping("")
    public ResponseEntity saveAllResult(@RequestBody List<ResultMultipleChoice> multipleChoices){
        String staticNumber = GeneralStatic.randomAlphaNumeric(6);
        Integer userId = 0;
        for (ResultMultipleChoice choice: multipleChoices) {
            choice.setPackageUnique(staticNumber);
            if(choice.getIdAnswer()==null){
                choice.setIdAnswer(0);
            }
        }

        List<ResultMultipleChoice>  resultMultipleChoices =  resultmultipleChoiceDAO.saveAll(multipleChoices);

        SummaryStandardResult summaryStandardResult = new SummaryStandardResult();
        summaryStandardResult.setUserId(resultMultipleChoices.get(0).getIdUser());
        summaryStandardResult.setPackageUnique(staticNumber);
        summaryStandardResult.setCreatedAt(new Date());
        summaryStandardResult.setTimeInSecond(5);

        summaryStandardResultDAO.save(summaryStandardResult);



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
