package com.neo.prudential.assignment.car.repository;

import com.neo.prudential.assignment.car.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author neo
 * @date 2022/12/8
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
