package com.fiap.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.entity.DeviceEntity;
import com.fiap.entity.UserEntity;


public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

	Set<DeviceEntity> findByUser(UserEntity userId);
}
