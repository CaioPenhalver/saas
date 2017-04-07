package com.fiap.facade;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.entity.LoginEntity;
import com.fiap.entity.UserEntity;
import com.fiap.repository.UserRepository;

/**
 * Created by logonrm on 25/03/2017.
 */

@RestController
@RequestMapping("/user")
public class UserFacade {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<UserEntity> listar() {
		return userRepository.findAll();
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public UserEntity login(@RequestBody LoginEntity login) {
		return userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public UserEntity signup(@RequestBody UserEntity user) {
		UserEntity newUser = new UserEntity(user.getName(), user.getEmail(), user.getPassword());
		return userRepository.save(newUser);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public String deleteAccount(@PathVariable("id") String id){
		userRepository.delete(Long.parseLong(id));
		return "User deleted successfully";
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public UserEntity updateAccount(@RequestBody UserEntity newUser){
		UserEntity user = userRepository.findOne((long)newUser.getId());
		user.setEmail(newUser.getEmail());
		user.setName(newUser.getName());
		user.setPassword(newUser.getPassword());
		return userRepository.saveAndFlush(user);
	}
}
