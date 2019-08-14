package id.hikari.hikari.test.data.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class ResponseQuestionDTO implements Serializable {
    /*
        *
     */
    private static final long serialVersionUID = -3619302622968502865L;

    private Integer id;
    private String question;
    private Integer questionType;
    private Integer questionLevel;
    private List<ResponseAnswerDTO> answers;

}
