package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.data.model.QuestionLevel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/question_levels")
@RestController
public class QuestionLevelEndPointImpl extends BaseEndPointImpl<QuestionLevel,Integer> {
}
