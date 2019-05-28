package ro.utcn.sp1tz3.Assignment3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"title"})
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;
    private String title;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private List<Question> questions;

    public Tag(String title){
        this.title = title;
    }
}
