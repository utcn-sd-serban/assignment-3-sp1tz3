package ro.utcn.sp1tz3.Assignment3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.dto.AnswerDTO;
import ro.utcn.sp1tz3.Assignment3.dto.QuestionDTO;
import ro.utcn.sp1tz3.Assignment3.entity.Answer;
import ro.utcn.sp1tz3.Assignment3.entity.Question;
import ro.utcn.sp1tz3.Assignment3.entity.Tag;
import ro.utcn.sp1tz3.Assignment3.exception.AnswerNotFoundException;
import ro.utcn.sp1tz3.Assignment3.repository.AnswerRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerManagementService {
    private final AnswerRepository repositoryFactory;

    @Transactional
    public List<AnswerDTO> listAnswers(){
        return repositoryFactory.findAll().stream().map(AnswerDTO::ofEntity).collect(Collectors.toList());
    }

    @Transactional
    public AnswerDTO addAnswer(int questionId, int userId, String text){
        return AnswerDTO.ofEntity(repositoryFactory.save(new Answer(questionId, userId, text, LocalDateTime.now())));
    }

    @Transactional
    public void removeAnswer(int id){
        Answer answer = repositoryFactory.findById(id).orElseThrow(AnswerNotFoundException::new);
        repositoryFactory.delete(answer);
    }

    public AnswerDTO get(int id){
        return AnswerDTO.ofEntity(repositoryFactory.findById(id).orElseThrow(AnswerNotFoundException::new));
    }

    @Transactional
    public AnswerDTO edit(int id, String text){
        Answer answer = repositoryFactory.findById(id).orElseThrow(AnswerNotFoundException::new);
        answer.setText(text);
        answer.setCreationDate(LocalDateTime.now());
        return AnswerDTO.ofEntity(repositoryFactory.save(answer));
    }

    @Transactional
    public List<AnswerDTO> getAnswersOfQuestion(int questionId){
        List<AnswerDTO> allAnswers = listAnswers();
        List<AnswerDTO> neededAnswers = new ArrayList<>();
        allAnswers.forEach(a->{
            if(a.getQuestionId() == questionId)
                neededAnswers.add(a);
        });
        return neededAnswers;
    }

}
