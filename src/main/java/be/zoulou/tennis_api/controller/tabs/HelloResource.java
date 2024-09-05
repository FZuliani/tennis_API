package be.zoulou.tennis_api.controller.tabs;

import be.zoulou.tennis_api.security.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {

    @Autowired
    private JwtUtils jwtUtils;
}
