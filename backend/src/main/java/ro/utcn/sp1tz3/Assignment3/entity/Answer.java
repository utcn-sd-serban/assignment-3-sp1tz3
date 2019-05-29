package ro.utcn.sp1tz3.Assignment3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerId;
    private Integer questionId;
    private Integer userId;
    private String text;
    private LocalDateTime creationDate;

    public Answer(Integer questionid, Integer userid, String text, LocalDateTime creationdate){
        this.questionId = questionid;
        this.userId = userid;
        this.text = text;
        this.creationDate = creationdate;
    }
}
