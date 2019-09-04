package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "question_type")
public class QuestionType implements Serializable {

    private static final long serialVersionUID = -7722915876645531832L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_type")
    private String questionType;
}
