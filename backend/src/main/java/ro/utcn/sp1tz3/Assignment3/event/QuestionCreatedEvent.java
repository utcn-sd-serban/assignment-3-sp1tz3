package ro.utcn.sp1tz3.Assignment3.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.utcn.sp1tz3.Assignment3.dto.QuestionDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionCreatedEvent extends BaseEvent{
    private final QuestionDTO question;

    public QuestionCreatedEvent(QuestionDTO question){
        super(EventType.QUESTION_CREATED);
        this.question = question;
    }
}
