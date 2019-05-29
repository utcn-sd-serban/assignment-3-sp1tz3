package ro.utcn.sp1tz3.Assignment3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.entity.User;
import ro.utcn.sp1tz3.Assignment3.exception.UserNotFoundException;
import ro.utcn.sp1tz3.Assignment3.repository.UserRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user = repository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown User"));
       return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
               Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Transactional
    public User loadCurrentUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findByUsername(name).orElseThrow(UserNotFoundException::new);
    }
}
