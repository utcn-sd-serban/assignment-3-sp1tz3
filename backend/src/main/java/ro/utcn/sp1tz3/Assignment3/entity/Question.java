package ro.utcn.sp1tz3.Assignment3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"questionId", "userId", "title", "text", "creationDate", "tags"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private Integer userId;
    private String title;
    private String text;
    private LocalDateTime creationDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "question_tag",
    joinColumns = {@JoinColumn(name = "questionid")},
    inverseJoinColumns = {@JoinColumn(name = "tagid")})
    private List<Tag> tags;

    public Question(Integer userid, String title, String text, LocalDateTime creationdate, List<Tag> tags){
        this.userId = userid;
        this.title = title;
        this.text = text;
        this.creationDate = creationdate;
        this.tags = tags;
    }
}
