package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.data.model.QuestionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/question_types")
@RestController
public class QuestionTypeEndPointImpl  extends BaseEndPointImpl<QuestionType,Integer> {
}
