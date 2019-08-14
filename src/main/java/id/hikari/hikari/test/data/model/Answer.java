package id.hikari.hikari.test.data.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answer")
@Entity
public class Answer implements Serializable {
    private static final long serialVersionUID = -6265613694479206474L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Boolean status;

    private Integer idQuestion;

    private Character variable;

    private String answer;
}
