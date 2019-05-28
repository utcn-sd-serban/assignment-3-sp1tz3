package ro.utcn.sp1tz3.Assignment3.dto;

import lombok.Data;
import ro.utcn.sp1tz3.Assignment3.entity.User;

@Data
public class UserDTO {
    private Integer userId;
    private String username;
    private String password;

    public static UserDTO ofEntity(User user){
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
