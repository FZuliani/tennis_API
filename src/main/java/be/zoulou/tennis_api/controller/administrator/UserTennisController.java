package be.zoulou.tennis_api.controller.administrator;

import be.zoulou.tennis_api.exceptions.UserTennisNotFoundException;
import be.zoulou.tennis_api.model.administrator.Role;
import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.model.dto.UserTennisDto;
import be.zoulou.tennis_api.service.administrator.UserTennisService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{id}")
    public ResponseEntity<UserTennisDto> getUserTennisById(@PathVariable final Long id){
        UserTennis userTennis = userTennisService.getUserTennisById(id);
        if(userTennis == null){
            throw new UserTennisNotFoundException(id.toString());
        }
        return ResponseEntity.ok(UserTennisDto.from(userTennis));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserTennisDto> deleteUserTennis(@PathVariable final Long id){
        UserTennis userTennis = userTennisService.deleteUserTennis(id);
        return ResponseEntity.ok(UserTennisDto.from(userTennis));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserTennisDto> editUserTennis(@PathVariable final Long id, @RequestBody final UserTennisDto userTennisDTO){
        UserTennis userTennis = userTennisService.editUserTennis(id, UserTennis.from(userTennisDTO));
        return ResponseEntity.ok(UserTennisDto.from(userTennis));
    }

    @GetMapping("/user/userName/{username}")
    public ResponseEntity<UserTennisDto> getUserTennisByUsername(@PathVariable final String username){
        UserTennis userTennis = userTennisService.getUserTennisByUsername(username);
        if(userTennis == null){
            throw new UserTennisNotFoundException(username);
        }
        return ResponseEntity.ok(UserTennisDto.from(userTennis));
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<UserTennisDto> getUserTennisByEmail(@PathVariable final String email){
        UserTennis userTennis = userTennisService.getUserTennisByEmail(email);
        if(userTennis == null){
            throw new UserTennisNotFoundException(email);
        }
        return ResponseEntity.ok(UserTennisDto.from(userTennis));
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserTennisDto>> getUsersTennis(){
        List<UserTennis> usersTennis = userTennisService.getUsersTennis();

        if(usersTennis == null){
            throw new UserTennisNotFoundException("No users found");
        }
        Iterable<UserTennisDto> userTennisDtos = usersTennis.stream()
                .map(UserTennisDto::from)
                .toList();

        return ResponseEntity.ok(userTennisDtos);
    }
}
