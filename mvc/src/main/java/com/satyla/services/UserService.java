package com.satyla.services;

import com.satyla.model.User;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;

import java.util.Optional;
import java.util.Set;

/**
 * Created by kasia on 18.05.18.
 */
public interface UserService {

    User addUser(User user);

    Iterable<User> findAll();

    Optional<User> findUserByName(String name);

    Set<User> usersSet();

    void deleteUser(int id);

    Optional<User> findById(int id);

    String getRegisterErrorMessage(BindingResult bindingResult);

    boolean hasAnyError(BindingResult bindingResult, User user);

    Page<User> getUsersList(Integer pageNumber, Integer size);
}
