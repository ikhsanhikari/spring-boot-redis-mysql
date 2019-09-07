package id.hikari.hikari.test.endpoint.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping("/hikari")
@Controller
public class UserController {

    @GetMapping("/register")
    public String index(){
        return "user/index";
    }

    @GetMapping("/multiple")
    public String multipleChoiceStandard(@RequestParam("idUser") Integer idUser){
        return "user/multiple_choice_standard";
    }

    @GetMapping("/short-answer-standard")
    public String shortAnswerStandard(@RequestParam("idUser") Integer idUser,
                                      @RequestParam("packageUnique") String packageUnique){
        return "user/short_answer_standard";
    }

    @GetMapping("/standar-exercise")
    public String standarExcercise(){
        return "standar_exercise";
    }

    @GetMapping("/standard-exercise-result")
    public String standarExcerciseResult(@RequestParam("idUser") Integer idUser,
                                         @RequestParam("packageUnique") String packageUnique){
        return "user/standard_exercise_result";
    }
}
