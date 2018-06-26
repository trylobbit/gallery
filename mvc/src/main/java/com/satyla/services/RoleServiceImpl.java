package com.satyla.services;

import com.satyla.model.Role;
import com.satyla.model.RoleType;
import com.satyla.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kasia on 22.05.18.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(RoleType roleType) {
        return roleRepository.getRoleByRoleType(roleType);
    }
}
