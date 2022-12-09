INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('1', current_time(), current_time(), null, 'Toyota Camry', 0, 'SHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('2', current_time(), current_time(), null, 'BMW 650', 0, 'SHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('3', current_time(), current_time(), null, 'Toyota Camry', 0, 'SHELVES', 0);
INSERT INTO car.t_car (id, date_created, date_update, rent_time, model, remain_days_to_delivery, status, time_to_delivery) VALUES ('5', current_time(), current_time(), null, 'BMW 650', 0, 'SHELVES', 0);


delete from t_customer;
select * from t_car;
select * from t_rent_info;
select * from t_customer;
select * from t_car;
select * from t_customer;

select car0_.id as id1_0_, car0_.last_rented as last_ren2_0_, car0_.model as model3_0_, car0_.remain_days_to_delivery as remain_d4_0_, car0_.status as status5_0_, car0_.time_to_delivery as time_to_6_0_ from t_car car0_;


select * from t_rent_info;

select * from t_customer;
select * from t_car;
