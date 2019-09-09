package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSummaryStandardResult implements Serializable {
    private static final long serialVersionUID = 4812602711949011590L;

    private Integer id;
    private String username;
    private String email;
    private String phone;
    private Date createdAt;
    private String packageUnique;

}
