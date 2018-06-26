package com.satyla.services;

import com.satyla.model.Role;
import com.satyla.model.RoleType;
import com.satyla.model.User;
import com.satyla.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id)
                .ifPresent(userRepository::delete);
    }

    @Override
    public Optional<User> findById(int id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        Role role = roleService.getRole(RoleType.USER);
        Role role2 = roleService.getRole(RoleType.ADMIN);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        userRoles.add(role2);
        user.setRoles(userRoles);
        user.setPassword(generateHashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String generateHashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Override
    public Set<User> usersSet() {
        Iterable<User> users =userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        Optional<User> user = userRepository.getUserByName(name);
        return user.isPresent() ? user : Optional.empty();
    }

    @Override
    public String getRegisterErrorMessage(BindingResult bindingResult) {
        return bindingResult.hasErrors() ? "Please, fill out personal data form" : "Login has been taken";
    }

    @Override
    public boolean hasAnyError(BindingResult bindingResult, User user) {
        return bindingResult.hasErrors() || findUserByName(user.getName()).isPresent();
    }

    @Override
    public Page<User> getUsersList(Integer pageNumber, Integer size) {
        return userRepository.findAll(PageRequest.of(pageNumber, size));
    }
}
