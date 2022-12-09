create schema car default character set utf8mb4 collate utf8mb4_unicode_ci;

CREATE TABLE t_car (
  id varchar(255) NOT NULL COMMENT 'Id',
  rent_time datetime DEFAULT NULL COMMENT 'rent time',
  model varchar(255) DEFAULT NULL COMMENT 'car model',
  remain_days_to_delivery int DEFAULT NULL ,
  status varchar(255) DEFAULT NULL,
  time_to_delivery int DEFAULT NULL,
  date_created datetime DEFAULT NULL,
  date_update datetime DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE t_customer (
  id varchar(255) NOT NULL,
  name varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  rent_id int DEFAULT NULL,
  date_created datetime DEFAULT NULL,
  date_update datetime DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE t_rent_info (
  id varchar(255) NOT NULL COMMENT 'Id',
  date_created datetime DEFAULT NULL,
  date_updated datetime DEFAULT NULL,
  order_time datetime DEFAULT NULL,
  start_delivery_time datetime DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  real_receive_time datetime DEFAULT NULL,
  expect_recieve_time datetime DEFAULT NULL,
  car_id varchar(255) DEFAULT NULL,
  customer_id varchar(255) DEFAULT NULL,
  date_update datetime NOT NULL,
  actual_receive_time datetime DEFAULT NULL,
  actual_return_time datetime DEFAULT NULL,
  expect_receive_time datetime DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE,
  KEY FKnxqiq3enxkyv7kkhewqcrmmmw (car_id),
  KEY FKb9jexda036hpwb20sy0bwck8t (customer_id),
  CONSTRAINT FKb9jexda036hpwb20sy0bwck8t FOREIGN KEY (customer_id) REFERENCES t_customer (id),
  CONSTRAINT FKnxqiq3enxkyv7kkhewqcrmmmw FOREIGN KEY (car_id) REFERENCES t_car (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

