package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseJsonData implements Serializable {
    List<DataResponse> dataResponses ;

    private static final long serialVersionUID = 5043046159517084241L;
    private String type;
    private String message;
}
