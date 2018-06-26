package com.satyla.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public RoleType roleType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return roleType.getName();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role1 = (Role) o;
        if (id != role1.id) {
            return false;
        }
        return roleType != null ? roleType.equals(role1.roleType) : role1.roleType == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        return result;
    }
}