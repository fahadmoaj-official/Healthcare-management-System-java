package com.hospital.model;

public class Department {
    private int id;
    private String name;
    private String headDoctor;

    public Department(int id, String name, String headDoctor) {
        this.id = id;
        this.name = name;
        this.headDoctor = headDoctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadDoctor() {
        return headDoctor;
    }

    public void setHeadDoctor(String headDoctor) {
        this.headDoctor = headDoctor;
    }
}
