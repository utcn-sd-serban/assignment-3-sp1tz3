package ro.utcn.sp1tz3.Assignment3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.dto.UserDTO;
import ro.utcn.sp1tz3.Assignment3.entity.User;
import ro.utcn.sp1tz3.Assignment3.exception.UserNotFoundException;
import ro.utcn.sp1tz3.Assignment3.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private final UserRepository repositoryFactory;

    @Transactional
    public List<UserDTO> listUsers(){ return repositoryFactory.findAll().stream().map(UserDTO::ofEntity).collect(Collectors.toList());}

    @Transactional
    public UserDTO addUser(String username, String password){
        User user = new User(username, password);
        return UserDTO.ofEntity(repositoryFactory.save(user));
    }

    @Transactional
    public void removeUser(int id){
        User user = repositoryFactory.findById(id).orElseThrow(UserNotFoundException::new);
        repositoryFactory.delete(user);
    }
}
