package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
