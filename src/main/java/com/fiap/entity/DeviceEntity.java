package com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "device", schema = "public", catalog = "smartenergy")
public class DeviceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique=true, nullable=false)
	private long id;

	@Column(name = "SERIALNUMBER", unique=true, nullable=false)
	private String serialNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", unique=false, nullable=false)
	@JsonIgnore
	private UserEntity user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public UserEntity getUserEntity() {
		return user;
	}

	public void setUserEntity(UserEntity user) {
		this.user = user;
	}

}
