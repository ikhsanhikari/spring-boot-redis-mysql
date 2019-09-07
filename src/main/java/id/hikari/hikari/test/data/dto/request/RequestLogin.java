package id.hikari.hikari.test.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class RequestLogin implements Serializable {
    private static final long serialVersionUID = -3914000590917148607L;
    private String username;
}
