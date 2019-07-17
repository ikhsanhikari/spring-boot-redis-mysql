package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "user")
@ToString
@Setter
@Getter
public class User implements Serializable {
    private static final long serialVersionUID = 4419205623903608091L;

    @Id
    private String id;

    private String name;

    private String email;
}
