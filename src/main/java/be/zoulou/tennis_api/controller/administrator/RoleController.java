package be.zoulou.tennis_api.controller.administrator;


import be.zoulou.tennis_api.model.administrator.Role;
import be.zoulou.tennis_api.model.dto.RoleDto;
import be.zoulou.tennis_api.service.administrator.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> getRoles(){
        List<Role> roles = roleService.getRoles();
        return ResponseEntity.ok(roles.stream().map(RoleDto::from).collect(Collectors.toList()));
    }
}
