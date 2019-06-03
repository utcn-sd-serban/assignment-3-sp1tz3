package ro.utcn.sp1tz3.Assignment3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.dto.QuestionDTO;
import ro.utcn.sp1tz3.Assignment3.entity.Question;
import ro.utcn.sp1tz3.Assignment3.entity.Tag;
import ro.utcn.sp1tz3.Assignment3.event.QuestionCreatedEvent;
import ro.utcn.sp1tz3.Assignment3.exception.QuestionNotFoundException;
import ro.utcn.sp1tz3.Assignment3.repository.QuestionRepository;
import ro.utcn.sp1tz3.Assignment3.repository.TagRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionManagementService {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public List<QuestionDTO> listQuestions(){
        return questionRepository.findAll().stream().map(QuestionDTO::ofEntity).collect(Collectors.toList());
    }

    @Transactional
    public QuestionDTO addQuestion(Integer userId, String title, String text, List<String> tags){
        LocalDateTime dateTime = LocalDateTime.now();
        List<Tag> thisTags = new ArrayList<>();
        List<Tag> allTags = tagRepository.findAll();
        tags.forEach(t->{
            thisTags.add(new Tag(t));
        });
        List<Tag> actualTags = new ArrayList<>();
        for(Tag t: thisTags){
            boolean contained = false;
            for(Tag a: allTags){
                if(a.getTitle().equals(t.getTitle())) {
                    contained = true;
                    actualTags.add(a);
                    break;
                }
            };
            if(!contained) {
                actualTags.add(tagRepository.save(t));
            }
        }
        QuestionDTO output = QuestionDTO.ofEntity(questionRepository.save(
                new Question(userId, title, text, dateTime, actualTags)));
        eventPublisher.publishEvent(new QuestionCreatedEvent(output));
        return output;
    }

    @Transactional
    public void removeQuestion(int id){
        Question question = questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
        questionRepository.delete(question);
    }

    public QuestionDTO get(int id){
        return QuestionDTO.ofEntity(questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new));
    }

    @Transactional
    public List<QuestionDTO> filterByTag(String tag){
        List<QuestionDTO> all = listQuestions();
        List<QuestionDTO> filtered = new ArrayList<>();
        all.forEach(t->{
            t.getTags().forEach(t2->{
                if(t2.equals(tag))
                    filtered.add(t);
            });
        });
        return filtered;
    }

    @Transactional
    public List<QuestionDTO> filterByTitle(String title){
        List<QuestionDTO> all = listQuestions();
        List<QuestionDTO> filtered = new ArrayList<>();
        all.forEach(t->{
            if(t.getTitle().contains(title))
                filtered.add(t);
        });
        return filtered;
    }
}
