package id.hikari.hikari.test.data.dto.response;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResponseMultipleResult implements Serializable {
    private static final long serialVersionUID = -9187964044274788688L;

    private Integer id;
    private Integer idQuestion;
    private Integer rightAnswer;
    private Integer userAnswer;
    private String packageUnique;





}
