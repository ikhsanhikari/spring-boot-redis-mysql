package id.hikari.hikari.test.data.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "result_short_answer")
public class ResultShortAnswer implements Serializable {
    private static final long serialVersionUID = 7482012443568305814L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer idUser;

    private Integer idQuestion;

    private String  idAnswer;

    private String packageUnique;
}
