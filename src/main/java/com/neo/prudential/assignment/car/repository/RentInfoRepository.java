package com.neo.prudential.assignment.car.repository;

import com.neo.prudential.assignment.car.entity.RentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author neo
 * @date 2022/12/8
 */
@Repository
@Transactional
public interface RentInfoRepository extends JpaRepository<RentInfo, String> {

    @Query("select t from RentInfo t where t.customer.id = :customerId")
    List<RentInfo> listByCustomerId(@Param("customerId") String customerId);
}
