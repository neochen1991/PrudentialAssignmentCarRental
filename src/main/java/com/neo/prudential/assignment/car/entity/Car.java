package com.neo.prudential.assignment.car.entity;
import com.neo.prudential.assignment.car.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author neo
 * @date 2022/12/8
 */
@Data
@Entity
@Table(name = "t_car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, columnDefinition = "CHAR(32)")
    private String id;

    private String model;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private int timeToDelivery = 4;

    private int remainDaysToDelivery;

    private LocalDateTime lastRented;

}
