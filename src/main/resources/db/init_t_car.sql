INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('1', current_time(), current_time(), null, 'Toyota Camry', 0, 'SHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('2', current_time(), current_time(), null, 'BMW 650', 0, 'SHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('3', current_time(), current_time(), null, 'Toyota Camry', 0, 'SHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('4', current_time(), current_time(), null, 'Toyota Camry', 0, 'UNSHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('5', current_time(), current_time(), null, 'BMW 650', 0, 'SHELVES', 0);


delete from car.t_car;
select * from t_car;

