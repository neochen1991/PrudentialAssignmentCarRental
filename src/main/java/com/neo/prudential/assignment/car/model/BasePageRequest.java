package com.neo.prudential.assignment.car.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author neo
 * @date 2022/12/8
 */
@Data
@NoArgsConstructor
public class BasePageRequest {

    int page = 0;

    int size = 20;

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }
}
