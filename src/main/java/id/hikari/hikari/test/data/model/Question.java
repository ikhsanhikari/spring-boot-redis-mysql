package id.hikari.hikari.test.data.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Question")
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = -8954706659702933803L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String question;

    private Integer questionType;

    private Integer questionLevel;

}
