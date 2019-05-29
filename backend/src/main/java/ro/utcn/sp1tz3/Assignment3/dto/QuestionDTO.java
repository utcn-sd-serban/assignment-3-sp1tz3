package ro.utcn.sp1tz3.Assignment3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ro.utcn.sp1tz3.Assignment3.entity.Question;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDTO {
    private Integer questionId;
    private Integer userId;
    private String title;
    private String text;
    private String creationDate;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> tags = new ArrayList<>();

    public static QuestionDTO ofEntity(Question question){
        QuestionDTO dto = new QuestionDTO();
        dto.setQuestionId(question.getQuestionId());
        dto.setUserId(question.getUserId());
        dto.setTitle(question.getTitle());
        dto.setText(question.getText());
        dto.setCreationDate(question.getCreationDate().toString());
        question.getTags().forEach(t->{
            dto.getTags().add(t.getTitle());
        });
        return dto;
    }

}
