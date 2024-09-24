package be.zoulou.tennis_api.model.administrator;

import be.zoulou.tennis_api.model.dto.UserTennisDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tennis")
public class UserTennis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 64)
    private String username;

    @Column(nullable = false, length = 64)
    private String oldPassword;

    @Column(nullable = false)
    private boolean actif;

    @ManyToMany
    @JoinTable(name = "user_roles")
    private List<Role> roles;

    public void addRole(Role role){
        roles.add(role);
    }

    public static UserTennis from(UserTennisDto userTennisDto) {
        UserTennis userTennis = new UserTennis();
       //userTennis.setId(userTennisDto.getId());
        userTennis.setEmail(userTennisDto.getEmail());
        userTennis.setPassword(userTennisDto.getPassword());
        userTennis.setUsername(userTennisDto.getUsername());
        userTennis.setOldPassword(userTennisDto.getOldPassword());
        userTennis.setActif(userTennisDto.isActif());
        userTennis.setRoles(userTennisDto.getRolesDto().stream().map(Role::from).toList());
        return userTennis;
    }
}
