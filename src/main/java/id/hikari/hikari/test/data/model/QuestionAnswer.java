package id.hikari.hikari.test.data.model;

import id.hikari.hikari.test.data.dto.response.ResponseMultipleResult;
import id.hikari.hikari.test.data.dto.response.ResponseMultipleResultAll;
import id.hikari.hikari.test.data.dto.response.ResponseResultShortAnswer;
import id.hikari.hikari.test.data.dto.response.ResponseSummaryStandardResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "result_multiple_mapping",
                classes = @ConstructorResult(
                        targetClass = ResponseMultipleResult.class,
                        columns = {
                            @ColumnResult(name = "id",type = Integer.class),
                            @ColumnResult(name = "id_question",type = Integer.class),
                            @ColumnResult(name = "right_answer",type = Integer.class),
                            @ColumnResult(name = "user_answer",type = Integer.class),
                            @ColumnResult(name = "package_unique",type = String.class),
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "result_short_answer_mapping",
                classes = @ConstructorResult(
                        targetClass = ResponseResultShortAnswer.class,
                        columns = {
                                @ColumnResult(name = "id",type = Integer.class),
                                @ColumnResult(name = "question",type = String.class),
                                @ColumnResult(name = "right_answer",type = String.class),
                                @ColumnResult(name = "user_answer",type = String.class),
                                @ColumnResult(name = "package_unique",type = String.class),
                                @ColumnResult(name = "status_answer",type = Integer.class),

                        }
                )
        ),
        @SqlResultSetMapping(
                name = "result_multiple_all_mapping",
                classes = @ConstructorResult(
                        targetClass = ResponseMultipleResultAll.class,
                        columns = {
                                @ColumnResult(name = "id",type = Integer.class),
                                @ColumnResult(name = "question",type = String.class),
                                @ColumnResult(name = "right_answer",type = Integer.class),
                                @ColumnResult(name = "right_variable",type = String.class),
                                @ColumnResult(name = "right_answer_value",type = String.class),
                                @ColumnResult(name = "user_answer",type = Integer.class),
                                @ColumnResult(name = "user_answer_variable",type = String.class),
                                @ColumnResult(name = "user_answer_value",type = String.class),
                                @ColumnResult(name = "package_unique",type = String.class),
                                @ColumnResult(name = "status_answer",type = Integer.class),
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "summary_mapping",
                classes = @ConstructorResult(
                        targetClass = ResponseSummaryStandardResult.class,
                        columns = {
                                @ColumnResult(name = "id",type = Integer.class),
                                @ColumnResult(name = "username",type = String.class),
                                @ColumnResult(name = "email",type = String.class),
                                @ColumnResult(name = "phone",type = String.class),
                                @ColumnResult(name = "created_at",type = Date.class),
                                @ColumnResult(name = "package_unique",type = String.class),
                        }
                )
        ),
})

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "QuestionAnswer.getResultMultiple",
                query = "select qa.id, qa.id_question, qa.id_answer " +
                        "as right_answer ,rmc.id_answer " +
                        "as user_answer, rmc.package_unique " +
                        "from question_answer qa , result_multiple_choice rmc " +
                        "where qa.id_question = rmc.id_question " +
                        "and rmc.package_unique = :packageUnique",
                resultSetMapping = "result_multiple_mapping"
        ),
        @NamedNativeQuery(
                name = "QuestionAnswer.getResultShortAnswer",
                query = "select sa.id, sa.question, sa.short_answer  " +
                        "as right_answer ,rmc.id_answer  " +
                        "as user_answer, rmc.package_unique, " +
                        "if(rmc.id_answer = sa.short_answer,1,0) as status_answer " +
                        "from short_answer sa , result_short_answer rmc  " +
                        "where sa.id = rmc.id_question " +
                        "and rmc.package_unique = :packageUnique",
                resultSetMapping = "result_short_answer_mapping"
        ),
        @NamedNativeQuery(
                name = "QuestionAnswer.getResultMultipleAll",
                query = "select qa.id, q.question,  " +
                        "qa.id_answer as right_answer , " +
                        "a.variable as right_variable , " +
                        "a.answer as right_answer_value, " +
                        "rmc.id_answer as user_answer, " +
                        "(select variable from answer where id = user_answer) as user_answer_variable, " +
                        "(select answer from answer where id = user_answer) as user_answer_value, " +
                        " rmc.package_unique  ,if(rmc.id_answer = qa.id_answer,1,0) as status_answer " +
                        "from question_answer qa ,  " +
                        "result_multiple_choice rmc , " +
                        "question q, " +
                        "answer a  " +
                        "where qa.id_question = rmc.id_question " +
                        "and q.id = qa.id_question " +
                        "and a.id = qa.id_answer " +
                        "and rmc.package_unique = :packageUnique ",
                resultSetMapping = "result_multiple_all_mapping"
        ),
        @NamedNativeQuery(
                name = "QuestionAnswer.getSummaryStandardResult",
                query = "Select ssr.id,gu.username ,gu.email, gu.phone, ssr.created_at, ssr.package_unique " +
                        "from guest_user gu, summary_standard_result ssr " +
                        "where gu.id = ssr.user_id order by ssr.id desc ",
                resultSetMapping = "summary_mapping"
        ),

})
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
