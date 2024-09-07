package com.Ecommerce.Ecommerce.domain.repository.User;

import com.Ecommerce.Ecommerce.domain.modal.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
