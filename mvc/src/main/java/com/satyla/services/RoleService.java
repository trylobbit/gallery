package com.satyla.services;

import com.satyla.model.Role;
import com.satyla.model.RoleType;

/**
 * Created by kasia on 22.05.18.
 */
public interface RoleService {

    Role getRole(RoleType roleType);
}
