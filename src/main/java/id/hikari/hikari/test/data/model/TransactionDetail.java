package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ToString
@Setter
@Getter
@Table(name = "transaction_detail")
@Entity
public class TransactionDetail implements Serializable {
    private static final long serialVersionUID = -2232275986898520136L;

    @Id
    private Integer id;
    private Integer idQuestion;
    private Integer idAnswer;

}
