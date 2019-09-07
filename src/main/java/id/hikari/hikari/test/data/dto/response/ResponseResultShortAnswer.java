package id.hikari.hikari.test.data.dto.response;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResponseResultShortAnswer implements Serializable {
    private static final long serialVersionUID = 4371241409905884793L;

    private Integer id;
    private String question;
    private String rightAnswer;
    private String userAnswer;
    private String packageUnique;
    private Integer status_answer;
}
