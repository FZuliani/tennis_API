//package be.zoulou.tennis_api.security.service.impl;
//import be.zoulou.tennis_api.model.administrator.UserTennis;
//import be.zoulou.tennis_api.security.security.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired()
//    public PasswordEncoder passwordEncoder;
//
//    @Value("{spring.app.jwtSecret}")
//    private String jwtSecret;
//
//    @Autowired
//    private final UserRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//        final UserTennis userTennis = this.repository.findByUsername(username);
//        if(userTennis == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        System.out.println("password encryted: " + passwordEncoder.encode(userTennis.getPassword()));
//        return User.withUsername(userTennis.getUsername())
//                .password(userTennis.getPassword())
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//    }
//}
