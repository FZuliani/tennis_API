package be.zoulou.tennis_api.controller.administrator;

import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.model.dto.UserTennisDto;
import be.zoulou.tennis_api.service.administrator.UserTennisService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class UserTennisController {

    private final UserTennisService userTennisService;

    @Autowired
    public UserTennisController(UserTennisService userTennisService) {
        this.userTennisService = userTennisService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserTennisDto> addUserTennis(@RequestBody final UserTennisDto userTennisDTO){
        UserTennis userTennis = userTennisService.addUserTennis(UserTennis.from(userTennisDTO));
        return ResponseEntity.ok(UserTennisDto.from(userTennis));
    }
}
