package be.zoulou.tennis_api.service.administrator;

import be.zoulou.tennis_api.exceptions.IdNotFoundException;
import be.zoulou.tennis_api.exceptions.UserTennisNotFoundException;
import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.repository.administrator.UserTennisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserTennisService {

    private final UserTennisRepository userTennisRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserTennisService(UserTennisRepository userTennisRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userTennisRepository = userTennisRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public UserTennis addUserTennis(UserTennis userTennis){
        String encodedPassword = passwordEncoder.encode(userTennis.getPassword());
        userTennis.setPassword(encodedPassword);
        return userTennisRepository.save(userTennis);
    }

    public List<UserTennis> getUsersTennis(){
        return StreamSupport.stream(userTennisRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public UserTennis getUserTennisById(Long id){
        return userTennisRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id, "UserTennis"));
    }

    public UserTennis getUserTennisByEmail(String email){
        System.out.println(userTennisRepository != null ?
                "UserTennisRepository is injected" : "UserTennisRepository is null");

        UserTennis userTennis = userTennisRepository.findByEmail(email);
        if(userTennis == null){
            throw new UserTennisNotFoundException(email);
        }
        return userTennis;
    }

    public UserTennis deleteUserTennis(Long id){
        UserTennis userTennis = getUserTennisById(id);
        userTennis.setActif(false);
        userTennisRepository.save(userTennis);
        return userTennis;
    }

    @Transactional
    public UserTennis editUserTennis(Long id, UserTennis userTennis){
        UserTennis userTennisToEdit = getUserTennisById(id);
        userTennisToEdit.setEmail(userTennis.getEmail());
        userTennisToEdit.setUsername(userTennis.getUsername());
        //userTennisToEdit.setOldPassword(userTennis.getOldPassword());
        //userTennisToEdit.setPassword(passwordEncoder.encode(userTennis.getPassword()));
        userTennisToEdit.setRoles(userTennis.getRoles());
        userTennisRepository.save(userTennisToEdit);
        return userTennisToEdit;
    }

    public UserTennis getUserTennisByUsername(String username) {
        return userTennisRepository.findByUsername(username);
    }
}
