package ro.utcn.sp1tz3.Assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sp1tz3.Assignment3.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
