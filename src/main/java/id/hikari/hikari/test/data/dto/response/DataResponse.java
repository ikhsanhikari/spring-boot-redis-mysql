package id.hikari.hikari.test.data.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class DataResponse implements Serializable {
    private static final long serialVersionUID = 6719738720208746210L;


    private String id;
    private String type;
    private Object attributes;


}
