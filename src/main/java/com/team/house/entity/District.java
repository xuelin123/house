package com.team.house.entity;

public class District {
    private Integer id;//区域编号

    private String name;//区域名称

    private Street street;//加载街道

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street=" + street +
                '}';
    }

    public District(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public District() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}