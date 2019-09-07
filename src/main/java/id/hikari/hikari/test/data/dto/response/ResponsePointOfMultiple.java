package id.hikari.hikari.test.data.dto.response;


import lombok.*;

import java.io.Serializable;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePointOfMultiple implements Serializable {
    private static final long serialVersionUID = 8066427162979402460L;

    private Integer point;
    private String packageUnique;
}
