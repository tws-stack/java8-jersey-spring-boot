package com.thoughtworks.gaia.product.entity;

import java.util.Date;

public class Product {
    private Long id;

    private String name;

    private Date timeCreated;

    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
}
