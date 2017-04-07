package com.fiap.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user", schema = "public", catalog = "smartenergy")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique=true, nullable=false)
    private long id;
	
	@Column(name = "name", unique=false, nullable=false)
    private String name;
	
	@Column(name = "email", unique=true, nullable=false)
    private String email;
	
	@Column(name = "password", unique=false, nullable=false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnore
    private Set<DeviceEntity> devices = new HashSet<>();
    
    public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
    public Set<DeviceEntity> getDevices() {
		return devices;
	}

	public void setDevices(Set<DeviceEntity> devices) {
		this.devices = devices;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
