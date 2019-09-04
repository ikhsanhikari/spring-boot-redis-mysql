package id.hikari.hikari.test.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLovDTO implements Serializable {
    private static final long serialVersionUID = -4360786950607557026L;
    private Integer id;
    private String name;
}
