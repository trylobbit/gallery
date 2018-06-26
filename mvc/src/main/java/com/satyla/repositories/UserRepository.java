package com.satyla.repositories;


import com.satyla.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

    Optional<User> getUserByName(String name);

    @Override
    default Iterable<User> findAll(Sort sort) {
        return null;
    }


}
