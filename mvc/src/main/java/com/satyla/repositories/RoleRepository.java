package com.satyla.repositories;

import com.satyla.model.Role;
import com.satyla.model.RoleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role getRoleByRoleType(RoleType roleType);

}
