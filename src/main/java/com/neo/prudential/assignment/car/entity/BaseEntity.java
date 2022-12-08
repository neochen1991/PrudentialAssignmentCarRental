package com.neo.prudential.assignment.car.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.neo.prudential.assignment.car.json.JsonBinaryType;
import com.neo.prudential.assignment.car.json.JsonStringType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.Getter;
import lombok.Setter;

/**
 * @author neo
 * @date 2022/12/8
 */
public abstract class BaseEntity implements Serializable {


    @Column(nullable = false, updatable = false)
    protected LocalDateTime dateCreated;

    @Column(nullable = false)
    protected LocalDateTime dateUpdate;


    @PrePersist
    private void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.dateCreated = now;
        this.dateUpdate = now;
    }

    @PreUpdate
    private void preUpdate() {
        this.dateUpdate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }


}
