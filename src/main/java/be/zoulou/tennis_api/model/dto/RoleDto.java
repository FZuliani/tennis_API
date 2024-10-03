package be.zoulou.tennis_api.model.dto;


import be.zoulou.tennis_api.model.administrator.Role;
import lombok.Data;

@Data
public class RoleDto {

    private Long id;
    private String name;

    public static RoleDto from (Role role){
        if (role == null){
            return null;
        }
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
