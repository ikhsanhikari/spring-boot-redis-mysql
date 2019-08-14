package id.hikari.hikari.test.service.impl;


import id.hikari.hikari.test.dao.AnswerDAO;
import id.hikari.hikari.test.dao.QuestionAnswerDAO;
import id.hikari.hikari.test.dao.QuestionDAO;
import id.hikari.hikari.test.dao.QuestionRedisDAO;
import id.hikari.hikari.test.data.dto.request.RequestAnswerDTO;
import id.hikari.hikari.test.data.dto.request.RequestQuestionDTO;
import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.data.dto.response.ResponseAnswerDTO;
import id.hikari.hikari.test.data.dto.response.ResponseQuestionDTO;
import id.hikari.hikari.test.data.model.Answer;
import id.hikari.hikari.test.data.model.Question;
import id.hikari.hikari.test.data.model.QuestionAnswer;
import id.hikari.hikari.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    private QuestionAnswerDAO questionAnswerDAO;

    @Autowired
    private QuestionRedisDAO questionRedisDAO;


    @Transactional
    @Override
    public void save(RequestQuestionDTO questionDTO) {
        Question question = new Question();
        QuestionAnswer questionAnswer = new QuestionAnswer();
        List<Answer> answers = new ArrayList<>();

        question.setQuestion(questionDTO.getQuestion());
        question.setQuestionLevel(questionDTO.getQuestionLevel());
        question.setQuestionType(questionDTO.getQuestionType());
        questionDAO.save(question);

        Character variable = 'A';
        for(RequestAnswerDTO answerDTO: questionDTO.getAnswers()){
            Answer answer = new Answer();
            answer.setStatus(answerDTO.getStatus());
            answer.setAnswer(answerDTO.getAnswer());
            answer.setIdQuestion(question.getId());
            answer.setVariable(variable);
            answers.add(answer);
            variable++;
        }
        List<Answer> answerList = answerDAO.saveAll(answers);

        for (Answer answer: answerList){
            if(answer.getStatus()){
                questionAnswer.setIdAnswer(answer.getId());
                questionAnswer.setIdQuestion(question.getId());
                questionAnswerDAO.save(questionAnswer);
                break;
            }
        }

        questionRedisDAO.deleteCache("*");
    }

    @Override
    public List<ResponseQuestionDTO> selectAll() {
        List<ResponseQuestionDTO> result = new ArrayList<>();
        List<Question> questions = questionDAO.findAll();


        for (Question question: questions){

            List<ResponseAnswerDTO> answerDTOS = new ArrayList<>();
            ResponseQuestionDTO questionDTO = new ResponseQuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setQuestionLevel(question.getQuestionLevel());
            questionDTO.setQuestionType(question.getQuestionType());
            questionDTO.setQuestion(question.getQuestion());
            List<Answer> answers  = answerDAO.findAnswerByQuestion(question.getId());

            for (Answer answer : answers) {
                ResponseAnswerDTO answerDTO = new ResponseAnswerDTO();
                answerDTO.setId(answer.getId());
                answerDTO.setAnswer(answer.getAnswer());
                answerDTO.setVariable(answer.getVariable());
                answerDTOS.add(answerDTO);
            }
            questionDTO.setAnswers(answerDTOS);

            result.add(questionDTO);

        }

        return result;
    }

    @Override
    public ResponseQuestionDTO getById(Integer idQuestion) throws Exception {
        ResponseQuestionDTO result = new ResponseQuestionDTO();
        Question question = questionDAO.findById(idQuestion).orElse(null);
        if(question==null){
            throw new Exception("Question param is null");
        }
        result.setId(question.getId());
        result.setQuestionLevel(question.getQuestionLevel());
        result.setQuestionType(question.getQuestionType());
        result.setQuestion(question.getQuestion());

        List<ResponseAnswerDTO> answerDTOS = new ArrayList<>();
        List<Answer> answers  = answerDAO.findAnswerByQuestion(idQuestion);

        for (Answer answer : answers) {
            ResponseAnswerDTO answerDTO = new ResponseAnswerDTO();
            answerDTO.setId(answer.getId());
            answerDTO.setAnswer(answer.getAnswer());
            answerDTO.setVariable(answer.getVariable());
            answerDTOS.add(answerDTO);
        }
        result.setAnswers(answerDTOS);
        return result;
    }

    @Override
    public DataResponse select() {
        ResponseQuestionDTO[] question = questionRedisDAO.selectFromCache("*");
        if (question!=null ) {
            return new DataResponse("All Questions","Questions",question);
        } else {
            List<ResponseQuestionDTO> questionDB = selectAll();
            questionRedisDAO.setToCache("*",questionDB);
            return new DataResponse("All Questions","Questions",questionDB);
        }
    }

    @Override
    public DataResponse get(String id) {
        Integer idInt = Integer.parseInt(id);
        ResponseQuestionDTO user = questionRedisDAO.getFromCache(id);
        if(user!=null){
            return new DataResponse(id,"Questions",user);
        }else{
            ResponseQuestionDTO questionDTO = null;
            try {
                questionDTO = getById(idInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            questionRedisDAO.setToCache(id,questionDTO);
            return new DataResponse(id,"Questions",questionDTO);
        }
    }
}
