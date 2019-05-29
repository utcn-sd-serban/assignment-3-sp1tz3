package ro.utcn.sp1tz3.Assignment3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sp1tz3.Assignment3.dto.AnswerDTO;
import ro.utcn.sp1tz3.Assignment3.dto.QuestionDTO;
import ro.utcn.sp1tz3.Assignment3.service.AnswerManagementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerManagementService answerManagementService;

    @GetMapping("/answers")
    public List<AnswerDTO> all(){
        return answerManagementService.listAnswers();
    }

    @GetMapping("/answers/{id}")
    public AnswerDTO readById(@PathVariable int id){
        return answerManagementService.get(id);
    }

    @PostMapping("/answers")
    public AnswerDTO addAnswer(@RequestBody AnswerDTO dto){
        return answerManagementService.addAnswer(dto.getQuestionId(),dto.getUserId(),dto.getText());
    }

    @GetMapping("/answers/ofQuestion/{questionId}")
    public List<AnswerDTO> answersOfQuestion(@PathVariable int questionId){
        return answerManagementService.getAnswersOfQuestion(questionId);
    }
}
