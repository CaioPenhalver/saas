package com.fiap.repository;

import com.fiap.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by logonrm on 25/03/2017.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByEmailAndPassword(String email, String password);
}
