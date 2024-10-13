package be.zoulou.tennis_api.security.service.impl;
import be.zoulou.tennis_api.model.administrator.Role;
import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.security.security.repository.UserRepository;
import be.zoulou.tennis_api.service.administrator.UserTennisService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    public PasswordEncoder passwordEncoder;
    private final UserTennisService userTennisService;

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    @Autowired
    public UserDetailsServiceImpl(UserTennisService userTennisService,
                                  PasswordEncoder passwordEncoder) {
        this.userTennisService = userTennisService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        System.out.println(userTennisService != null ?
                "UserTennisService is injected" : "UserTennisService is null");

        assert userTennisService != null;
        UserTennis userTennis = userTennisService.getUserTennisByUsername(username);
        if(userTennis == null) {
            throw new UsernameNotFoundException("Unknown user "+ username);
        }

        Set<Role> roles = userTennis.getRoles();

        return User.withUsername(userTennis.getUsername())
                .password(userTennis.getPassword())
                .authorities(getAuthorities(roles, userTennis))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roleSet, UserTennis userTennis)
    {
        Set<Role> roles = userTennis.getRoles();

        return getGrantedAuthorities(roles, userTennis);
    }

    public static String getUserId(UserTennis userTennis) {
        return Long.toString(userTennis.getId());
    }

    public Set<Role> getRoles(List<Role> roleList) {
        return new HashSet<>(roleList);
    }

    public static List<GrantedAuthority> getGrantedAuthorities(Set<Role> roles, UserTennis userTennis) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        authorities.add(new SimpleGrantedAuthority(getUserId(userTennis)));

        return authorities;
    }

}

