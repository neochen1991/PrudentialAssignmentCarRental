package com.neo.prudential.assignment.car.entity;

import com.neo.prudential.assignment.car.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author neo
 * @date 2022/12/8
 */
@Data
@Entity
@Table(name = "t_customer")
@Cacheable(false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, columnDefinition = "CHAR(32)")
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private String ticket;

}
