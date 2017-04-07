package com.fiap.facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.entity.DeviceEntity;
import com.fiap.entity.UserEntity;
import com.fiap.repository.DeviceRepository;
import com.fiap.repository.UserRepository;

/**
 * Created by logonrm on 25/03/2017.
 */

@RestController
@RequestMapping("/{userId}/device")
public class DeviceFacade {

    @Autowired
    DeviceRepository deviceRepository;
    
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/list", produces = "application/json", method = RequestMethod.GET)
    public Map<Long, String> list(@PathVariable String userId){
    	return this.getDevices(userRepository.findOne(Long.parseLong(userId)).getDevices());
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Map<Long, String> newDevice(@PathVariable String userId, @RequestBody DeviceEntity device){
    	UserEntity user = userRepository.findOne(Long.parseLong(userId));
    	device.setUserEntity(user);
    	user.getDevices().add(device);
    	deviceRepository.save(device);
    	return this.getDevices(userRepository.findOne(Long.parseLong(userId)).getDevices());
    	
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public Map<Long, String> deleteDevice(@PathVariable String userId, @PathVariable String id){
    	deviceRepository.delete(Long.parseLong(id));
    	return this.getDevices(userRepository.findOne(Long.parseLong(userId)).getDevices());
    }
    
    private Map<Long, String> getDevices(Set<DeviceEntity> devices){
    	Map<Long, String> deviceList = new HashMap<>();
    	for(DeviceEntity device : devices){
    		deviceList.put(device.getId(), device.getSerialNumber());
    	}
    	return deviceList;
    }
}
