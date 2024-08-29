package be.zoulou.tennis_api.security.security.entity;

import jakarta.persistence.*;

@Entity
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

    public UserTennis() {
    }

    public UserTennis(Long id,  String email, String password, String username, String oldPassword) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.oldPassword = oldPassword;
    }
}
