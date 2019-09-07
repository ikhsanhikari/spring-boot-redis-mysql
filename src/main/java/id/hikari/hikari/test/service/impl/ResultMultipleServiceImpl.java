package id.hikari.hikari.test.service.impl;

import id.hikari.hikari.test.dao.QuestionAnswerDAO;
import id.hikari.hikari.test.data.dto.response.ResponseMultipleResult;
import id.hikari.hikari.test.data.dto.response.ResponsePointOfMultiple;
import id.hikari.hikari.test.service.ResultMultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultMultipleServiceImpl implements ResultMultipleService {

    @Autowired
    private QuestionAnswerDAO questionAnswerDAO;

    @Override
    public ResponseEntity getResultMultiple(String packageUnique) {
        List<ResponseMultipleResult> multipleResultList = questionAnswerDAO.getResultMultiple(packageUnique);
        Integer point = 0;
        for (ResponseMultipleResult result : multipleResultList){
            if(result.getRightAnswer().equals(result.getUserAnswer())){
                point ++;
            }
        }
        return ResponseEntity.ok(new ResponsePointOfMultiple(point,packageUnique));
    }
}
