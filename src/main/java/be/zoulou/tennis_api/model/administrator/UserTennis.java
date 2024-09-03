package be.zoulou.tennis_api.model.administrator;

import be.zoulou.tennis_api.model.dto.UserTennisDto;
import jakarta.persistence.*;
import lombok.*;

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


    public static UserTennis from(UserTennisDto userTennisDto) {
        UserTennis userTennis = new UserTennis();
       // userTennis.setId(userTennisDto.getId());
        userTennis.setEmail(userTennisDto.getEmail());
        userTennis.setPassword(userTennisDto.getPassword());
        userTennis.setUsername(userTennisDto.getUsername());
        userTennis.setOldPassword(userTennisDto.getOldPassword());
        return userTennis;
    }
}
