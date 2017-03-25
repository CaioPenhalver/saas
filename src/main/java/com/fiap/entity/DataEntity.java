package com.fiap.entity;

import javax.persistence.*;

/**
 * Created by logonrm on 25/03/2017.
 */
@Entity
@Table(name = "data", schema = "public", catalog = "smartenergy")
public class DataEntity {
    private int id;
    private int deviceId;
    private String deviceData;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_id")
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "device_data")
    public String getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(String deviceData) {
        this.deviceData = deviceData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataEntity that = (DataEntity) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (deviceData != null ? !deviceData.equals(that.deviceData) : that.deviceData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + deviceId;
        result = 31 * result + (deviceData != null ? deviceData.hashCode() : 0);
        return result;
    }
}
