package ro.utcn.sp1tz3.Assignment3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sp1tz3.Assignment3.dto.UserDTO;
import ro.utcn.sp1tz3.Assignment3.entity.User;
import ro.utcn.sp1tz3.Assignment3.service.UserDetailsService;
import ro.utcn.sp1tz3.Assignment3.service.UserManagementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserManagementService userManagementService;
    private final UserDetailsService userDetailsService;

    @GetMapping("/users")
    public List<UserDTO> all(){
        return userManagementService.listUsers();
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO dto){
        return userManagementService.addUser(dto.getUsername(), dto.getPassword());
    }

    @GetMapping("/me")
    public User readCurrent(){
        return userDetailsService.loadCurrentUser();
    }

}
