package com.fiap.facade;

import com.fiap.entity.UserEntity;
import com.fiap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by logonrm on 25/03/2017.
 */

@RestController
@RequestMapping("/user")
public class UserFacade {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/list")
    public List<UserEntity> listar(){
        return userRepository.findAll();
    }
}
