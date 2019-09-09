package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "summary_standard_result")
@Setter
@Getter
@ToString
public class SummaryStandardResult implements Serializable {

    private static final long serialVersionUID = 533446423769059092L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String packageUnique;

    private Date createdAt;

    private Integer timeInSecond;
}
