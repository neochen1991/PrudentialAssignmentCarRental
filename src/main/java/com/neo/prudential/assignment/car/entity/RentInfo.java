package com.neo.prudential.assignment.car.entity;

import com.neo.prudential.assignment.car.enums.RentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author neo
 * @date 2022/12/8
 */
@Data
@Entity
@Table(name = "t_rent_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentInfo extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, columnDefinition = "CHAR(32)")
    private String id;

    private RentStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime orderTime;

    private LocalDateTime startDeliveryTime;

    private LocalDateTime expectReceiveTime;

    private LocalDateTime actualReturnTime;

    private LocalDateTime actualReceiveTime;

}
