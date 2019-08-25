package com.team.house.entity;

public class Street {
    private Integer id;

    private String name;

    private Integer districtId;

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", districtId=" + districtId +
                '}';
    }

    public Street() {
    }

    public Street(Integer id, String name, Integer districtId) {
        this.id = id;
        this.name = name;
        this.districtId = districtId;
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

    public Integer getDistrictId(Integer did) {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
}