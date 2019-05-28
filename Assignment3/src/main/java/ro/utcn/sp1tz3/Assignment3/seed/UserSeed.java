package ro.utcn.sp1tz3.Assignment3.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.entity.User;
import ro.utcn.sp1tz3.Assignment3.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserSeed implements CommandLineRunner {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        if(repository.findAll().isEmpty()){
            repository.save(new User("a",passwordEncoder.encode("a")));
            repository.save(new User("Sp1Tz3",passwordEncoder.encode("haha")));
            repository.save(new User("Allah",passwordEncoder.encode("aaa")));
            repository.save(new User("Hatz",passwordEncoder.encode("Johnule")));
        }
    }
}
