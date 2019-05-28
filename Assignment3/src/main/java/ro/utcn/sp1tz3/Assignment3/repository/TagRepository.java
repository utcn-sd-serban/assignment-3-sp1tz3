package ro.utcn.sp1tz3.Assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sp1tz3.Assignment3.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
