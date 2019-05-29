package ro.utcn.sp1tz3.Assignment3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sp1tz3.Assignment3.dto.QuestionDTO;
import ro.utcn.sp1tz3.Assignment3.service.QuestionManagementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionManagementService questionManagementService;

    @GetMapping("/questions")
    public List<QuestionDTO> all(){
        return questionManagementService.listQuestions();
    }

    @GetMapping("/questions/{id}")
    public QuestionDTO readById(@PathVariable int id){
        return questionManagementService.get(id);
    }

    @PostMapping("/questions")
    public QuestionDTO addQuestion(@RequestBody QuestionDTO dto){
        return questionManagementService.addQuestion(dto.getUserId(), dto.getTitle(), dto.getText(), dto.getTags());
    }
}
