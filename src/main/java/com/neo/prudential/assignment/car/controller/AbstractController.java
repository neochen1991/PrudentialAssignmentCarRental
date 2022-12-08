package com.neo.prudential.assignment.car.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

/**
 * @author neo
 * @date 2022/12/8
 */
@Slf4j
@Controller
public abstract class AbstractController {

    private static final Sort PAGE_SORT = Sort.by(Sort.Direction.DESC, "timeLastUpdated");

    protected Pageable page(int start, int length) {
        return PageRequest.of(start / length, length, PAGE_SORT);
    }

    protected Pageable pageOf(int page, int size) {
        return PageRequest.of(page, size);
    }

    protected Pageable pageOf(int page, int size, Sort sort) {
        return PageRequest.of(page, size, sort);
    }

}
