package com.fiap.entity;

import javax.persistence.*;

/**
 * Created by logonrm on 25/03/2017.
 */
@Entity
@Table(name = "device", schema = "public", catalog = "smartenergy")
public class DeviceEntity {
    private int id;
    private String serialNumber;
    private Integer userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (id != that.id) return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
