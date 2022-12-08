package com.neo.prudential.assignment.car.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author neo
 * @date 2022/12/8
 */
@Data
@AllArgsConstructor
public class CarInStock {

    private String carModel;

    private int inStock;

    public static List<CarInStock> fromMap(Map<String, Long> map) {
        return map.keySet()
                .stream()
                .map(k -> new CarInStock(k, map.get(k).intValue()))
                .collect(Collectors.toList());
    }

}
