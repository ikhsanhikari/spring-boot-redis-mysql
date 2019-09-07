package id.hikari.hikari.test.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "result_multiple_choice")
public class ResultMultipleChoice  implements Serializable {
    private static final long serialVersionUID = 1342417291769239719L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer idUser;

    private Integer idQuestion;

    private Integer idAnswer;

    private String packageUnique;

}
