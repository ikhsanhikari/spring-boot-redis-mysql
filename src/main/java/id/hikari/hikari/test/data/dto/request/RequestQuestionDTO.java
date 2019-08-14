package id.hikari.hikari.test.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class RequestQuestionDTO implements Serializable {

    private static final long serialVersionUID = -5313002996575925073L;


    private String question;
    private Integer questionType;
    private Integer questionLevel;
    private List<RequestAnswerDTO> answers;
}
