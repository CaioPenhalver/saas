package com.fiap.facade;

import com.fiap.entity.DeviceEntity;
import com.fiap.entity.UserEntity;
import com.fiap.repository.DeviceRepository;
import com.fiap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by logonrm on 25/03/2017.
 */

@RestController
@RequestMapping("/divice")
public class DeviceFacade {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping("/list")
    public List<DeviceEntity> listar(){
        return deviceRepository.findAll();
    }
}
