package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse implements Serializable {
    private static final long serialVersionUID = 8467328054899864519L;

    private String type;
    private String message;
    private Object data;

}
