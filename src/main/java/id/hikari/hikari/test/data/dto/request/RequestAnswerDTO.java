package id.hikari.hikari.test.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class RequestAnswerDTO implements Serializable {

    private static final long serialVersionUID = 1058269694158334350L;

    private  Boolean status;
    private String answer;

}
