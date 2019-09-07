package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLogin implements Serializable {

    private static final long serialVersionUID = -18176085315095128L;

    private Boolean status;
    private Integer idUser;
}
