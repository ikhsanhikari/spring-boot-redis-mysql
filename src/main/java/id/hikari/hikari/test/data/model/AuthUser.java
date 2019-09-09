package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "auth_user")
@Setter
@Getter
@ToString
public class AuthUser implements Serializable {
    private static final long serialVersionUID = -4387091898479949636L;
    @Id
    private Long id;

    private String username;

    private String password;


}
