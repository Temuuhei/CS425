package erigstrar.eregistrarwebapp.service.impl;

import erigstrar.eregistrarwebapp.model.Role;
import erigstrar.eregistrarwebapp.repository.RoleRepository;
import erigstrar.eregistrarwebapp.service.RoleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }

}
