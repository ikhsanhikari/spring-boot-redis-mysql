package id.hikari.hikari.test.data.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class ResponseAnswerDTO implements Serializable {

    private static final long serialVersionUID = -8394982904098988140L;

    private Integer id;
    private Character variable;
    private String answer;
    private Boolean status;
}
