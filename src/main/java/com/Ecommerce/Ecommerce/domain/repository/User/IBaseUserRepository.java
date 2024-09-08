package com.Ecommerce.Ecommerce.domain.repository.User;

import com.Ecommerce.Ecommerce.domain.model.User.User;

import java.util.Optional;

public interface IBaseUserRepository {
    Optional<User> findByUsername(String username);
}
