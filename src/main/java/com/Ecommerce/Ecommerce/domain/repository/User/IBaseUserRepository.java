package com.Ecommerce.Ecommerce.domain.repository.User;

import com.Ecommerce.Ecommerce.domain.modal.User.User;

import java.util.Optional;

public interface IBaseUserRepository {
    Optional<User> findUserByName(String userName);
}
