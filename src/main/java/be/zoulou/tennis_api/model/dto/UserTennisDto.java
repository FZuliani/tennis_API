package be.zoulou.tennis_api.model.dto;

import be.zoulou.tennis_api.model.administrator.UserTennis;
import lombok.Data;

import java.util.List;

@Data
public class UserTennisDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String oldPassword;
    private boolean actif;
    private List<RoleDto> roles;

    public static UserTennisDto from(UserTennis userTennis) {
        UserTennisDto userTennisDto = new UserTennisDto();
        userTennisDto.setId(userTennis.getId());
        userTennisDto.setUsername(userTennis.getUsername());
        userTennisDto.setEmail(userTennis.getEmail());
        userTennisDto.setPassword(userTennis.getPassword());
        userTennisDto.setOldPassword(userTennis.getOldPassword());
        userTennisDto.setActif(userTennis.isActif());
        userTennisDto.setRoles(userTennis.getRoles().stream().map(RoleDto::from).toList());
        return userTennisDto;
    }
}
