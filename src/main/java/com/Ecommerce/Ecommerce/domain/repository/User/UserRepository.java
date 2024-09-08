package com.Ecommerce.Ecommerce.domain.repository.User;

import com.Ecommerce.Ecommerce.domain.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>,IBaseUserRepository {

}
