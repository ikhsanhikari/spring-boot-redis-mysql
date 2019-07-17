package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = -1985143252372089655L;

    private String type;
    private String message;
}
