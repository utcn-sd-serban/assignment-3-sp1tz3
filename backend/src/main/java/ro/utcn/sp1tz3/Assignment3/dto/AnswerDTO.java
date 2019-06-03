package ro.utcn.sp1tz3.Assignment3.dto;

import lombok.Data;
import ro.utcn.sp1tz3.Assignment3.entity.Answer;

@Data
public class AnswerDTO {
    private Integer answerId;
    private Integer userId;
    private Integer questionId;
    private String text;
    private String creationDate;

    public static AnswerDTO ofEntity(Answer answer){
        AnswerDTO dto = new AnswerDTO();
        dto.setAnswerId(answer.getAnswerId());
        dto.setQuestionId(answer.getQuestionId());
        dto.setUserId(answer.getUserId());
        dto.setText(answer.getText());
        dto.setCreationDate(answer.getCreationDate().toString());
        return dto;
    }
}
