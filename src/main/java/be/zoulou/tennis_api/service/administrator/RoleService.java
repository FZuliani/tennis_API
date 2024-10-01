package be.zoulou.tennis_api.service.administrator;

import be.zoulou.tennis_api.model.administrator.Role;
import be.zoulou.tennis_api.repository.administrator.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addRole(Role role){
        roleRepository.save(role);
        return role;
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> getRoles(){
        return StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Role editRole(Long id, Role role){
        Role roleToEdit = getRoleById(id);
        roleToEdit.setName(role.getName());
        roleRepository.save(roleToEdit);
        return roleToEdit;
    }
}