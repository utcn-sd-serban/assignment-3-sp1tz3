package ro.utcn.sp1tz3.Assignment3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sp1tz3.Assignment3.dto.QuestionDTO;
import ro.utcn.sp1tz3.Assignment3.event.BaseEvent;
import ro.utcn.sp1tz3.Assignment3.service.QuestionManagementService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionManagementService questionManagementService;
    private final SimpMessagingTemplate messagingTemplate;

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

    @GetMapping("/questions/filterTitle/{title}")
    public List<QuestionDTO> filterByTitle(@PathVariable String title){
        return questionManagementService.filterByTitle(title);
    }

    @GetMapping("/questions/filterTag/{tag}")
    public List<QuestionDTO> filterByTag(@PathVariable String tag){
        return questionManagementService.filterByTag(tag);
    }

    @EventListener(BaseEvent.class)
    public void handleEvent(BaseEvent event){
        log.info("Got an event: {}", event);
        messagingTemplate.convertAndSend("/topic/events", event);
    }
}
