package be.zoulou.tennis_api.controller.tabs;

import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.security.security.jwt.JwtUtils;
import be.zoulou.tennis_api.security.security.jwt.LoginRequest;
import be.zoulou.tennis_api.security.security.jwt.LoginResponse;
import be.zoulou.tennis_api.security.security.models.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HelloResource {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/public")
    public String helloPublic(){
        return "Hello Public";
    }

    @GetMapping("/welcome")
    public String helloUser(){
        return "Welcome to TennisBE API (welcome)";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Welcome to TennisBE API (admin)";
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication;
        try {
            for (int i = 0; i < 250; i++) {
                System.out.println("Made by Zoulou");
            }
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            ));
        } catch (AuthenticationException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsCustom userDetails = (UserDetailsCustom) authentication.getPrincipal();
        Long userId = userDetails.getUserId();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        LoginResponse response = new LoginResponse(jwtToken, userDetails.getUsername(), roles, userId);

        return ResponseEntity.ok(response);
    }
}
