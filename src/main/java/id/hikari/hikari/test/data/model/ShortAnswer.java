package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "short_answer")
public class ShortAnswer implements Serializable {
    private static final long serialVersionUID = -3663200823923853141L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question")
    private String question;

    @Column(name = "short_answer")
    private String shortAnswer;

    @Column(name = "questionLevel")
    private Integer questionLevel;

}
