package id.hikari.hikari.test.data.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ToString
@Setter
@Getter
@Entity
@Table(name = "ping")
public class Ping implements Serializable {
    private static final long serialVersionUID = 7162239200105016838L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ping")
    private  String ping;


}
