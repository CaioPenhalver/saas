package com.fiap.repository;


import com.fiap.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by logonrm on 25/03/2017.
 */
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

}
