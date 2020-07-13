package com.prography.playeasy.match.domain.models;

import androidx.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

public class Location{
    @SerializedName("id")
    int id;
    @SerializedName("latitude")
    float latitude;
    @SerializedName("longitude")
    float longitude;
    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;
    @SerializedName("detail")
    String detail;
//사라진 필
//    String createdAt;
//    String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
