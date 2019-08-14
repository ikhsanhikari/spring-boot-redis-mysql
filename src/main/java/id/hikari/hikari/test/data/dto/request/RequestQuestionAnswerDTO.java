package id.hikari.hikari.test.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class RequestQuestionAnswerDTO implements Serializable {

    private static final long serialVersionUID = -6874046011628805648L;

    private Integer idQuestion;
    private Integer idAnswer;
}
