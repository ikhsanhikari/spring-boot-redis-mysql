package id.hikari.hikari.test.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Setter
@Getter
@Table(name = "question_answer")
@Entity
public class QuestionAnswer implements Serializable {
    private static final long serialVersionUID = 8626513732339975405L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer idQuestion;

    private Integer idAnswer;
}
