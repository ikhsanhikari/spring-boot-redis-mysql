package id.hikari.hikari.test.endpoint.web;


import id.hikari.hikari.test.data.dto.response.DataResponse;
import id.hikari.hikari.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @Autowired
    private QuestionService  questionService;

    @GetMapping("/")
    public String index(ModelMap modelMap){
        DataResponse  dataResponse = questionService.select();
        modelMap.addAttribute("question",dataResponse);
        return "index";
    }

    @GetMapping("/question")
    public String question(){
        return "question";
    }

    @GetMapping("/create-question")
    public String createQuestion(){
        return "create_question";
    }


    @GetMapping("/answer")
    public String answer(){
        return "answer";
    }

    @GetMapping("/create-answer")
    public String createAnswer(){
        return "create_answer";
    }
}
