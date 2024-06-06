package com.usermanager.api.module.user.repository;

import com.usermanager.api.module.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByCpf(String cpf);
    Optional<UserModel> findByCpf(String cpf);
}
