package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResponseMultipleResultAll implements Serializable {
    private static final long serialVersionUID = 3893705576666557389L;

    private Integer id;
    private String question;
    private Integer rightAnswer;
    private String rightVariable;
    private String rightAnswerValue;
    private Integer userAnswer;
    private String userVariable;
    private String userAnswerValue;
    private String packageUnique;
    private Integer statusAnswer;

}
