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
@Table(name = "transaction")
@Entity
public class Transaction implements Serializable {
    private static final long serialVersionUID = 6705122052625141406L;

    @Id
    private Integer id;
    private Integer userId;
    private Integer transactionDetailId;


}
