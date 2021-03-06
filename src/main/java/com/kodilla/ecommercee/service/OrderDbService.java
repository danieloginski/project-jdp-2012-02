package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderDbService {

    private final OrderRepository orderRepository;


    public Optional<Order> getOrder(final Long id){
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(final Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(final Long id){
        orderRepository.deleteById(id);
    }
}
