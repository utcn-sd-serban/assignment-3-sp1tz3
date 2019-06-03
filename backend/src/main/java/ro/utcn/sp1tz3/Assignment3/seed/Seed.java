package ro.utcn.sp1tz3.Assignment3.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.entity.Question;
import ro.utcn.sp1tz3.Assignment3.entity.Tag;
import ro.utcn.sp1tz3.Assignment3.entity.User;
import ro.utcn.sp1tz3.Assignment3.repository.AnswerRepository;
import ro.utcn.sp1tz3.Assignment3.repository.QuestionRepository;
import ro.utcn.sp1tz3.Assignment3.repository.TagRepository;
import ro.utcn.sp1tz3.Assignment3.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Seed {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final AnswerRepository answerRepository;
    @Transactional
    public void run(String... args) {
        userRepository.save(new User(1, "a", passwordEncoder.encode("a")));
        userRepository.save(new User(2, "Sp1Tz3", passwordEncoder.encode("haha")));
        userRepository.save(new User(3, "Allah", passwordEncoder.encode("aaa")));
        userRepository.save(new User(4, "Hatz", passwordEncoder.encode("Johnule")));

        tagRepository.save(new Tag("Java"));
        tagRepository.save(new Tag("Spring"));

        questionRepository.save(new Question(userRepository.findAll().get(0).getUserId(), "asd", "asd", LocalDateTime.now(), tagRepository.findAll()));
    }

    @Transactional
    public void clear(){
        answerRepository.deleteAll();
        tagRepository.deleteAll();
        questionRepository.deleteAll();
        userRepository.deleteAll();
    }
}
