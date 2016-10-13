package com.thoughtworks.gaia.common.jpa;

import org.joda.time.DateTime;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBaseModel extends IdBaseModel {
    @Column(name = "time_created", nullable = false, updatable = false)
    private Date timeCreated;

    public EntityBaseModel() {
        timeCreated = DateTime.now().toDate();
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
}
