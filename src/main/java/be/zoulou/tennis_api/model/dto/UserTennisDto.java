package be.zoulou.tennis_api.model.dto;

import be.zoulou.tennis_api.model.administrator.UserTennis;
import lombok.Data;

@Data
public class UserTennisDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String oldPassword;

    public static UserTennisDto from(UserTennis userTennis) {
        UserTennisDto userTennisDto = new UserTennisDto();
        userTennisDto.setId(userTennis.getId());
        userTennisDto.setUsername(userTennis.getUsername());
        userTennisDto.setEmail(userTennis.getEmail());
        userTennisDto.setPassword(userTennis.getPassword());
        userTennisDto.setOldPassword(userTennis.getOldPassword());
        return userTennisDto;
    }
}
