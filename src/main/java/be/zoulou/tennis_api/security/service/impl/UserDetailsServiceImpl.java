package be.zoulou.tennis_api.security.service.impl;
import be.zoulou.tennis_api.model.administrator.Role;
import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.repository.administrator.UserTennisRepository;
import be.zoulou.tennis_api.security.security.models.UserDetailsCustom;
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
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    public PasswordEncoder passwordEncoder;
    private final UserTennisService userTennisService;
    @Autowired
    private UserTennisRepository userTennisRepository;

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    @Autowired
    public UserDetailsServiceImpl(UserTennisService userTennisService,
                                  PasswordEncoder passwordEncoder,
                                  UserTennisRepository userTennisRepository) {
        this.userTennisService = userTennisService;
        this.passwordEncoder = passwordEncoder;
        this.userTennisRepository = userTennisRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTennis user = userTennisRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new UserDetailsCustom(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
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
            authorities.add(new SimpleGrantedAuthority( "ROLE_" + role.getName()));
        }

        authorities.add(new SimpleGrantedAuthority(getUserId(userTennis)));

        return authorities;
    }

}

