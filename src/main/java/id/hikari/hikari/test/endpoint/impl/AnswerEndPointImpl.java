package id.hikari.hikari.test.endpoint.impl;

import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.data.model.Answer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/answers")
@RestController
public class AnswerEndPointImpl extends BaseEndPointImpl<Answer,Integer> {
}
