package ro.utcn.sp1tz3.Assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sp1tz3.Assignment3.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
