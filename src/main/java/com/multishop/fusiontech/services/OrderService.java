package com.multishop.fusiontech.services;

import com.multishop.fusiontech.dtos.order.OrderCreateDto;
import com.multishop.fusiontech.dtos.order.OrderDto;
import com.multishop.fusiontech.dtos.order.OrderUpdateDto;
import com.multishop.fusiontech.payloads.PaginationPayload;

import java.util.List;

public interface OrderService {

    boolean createOrder(String userEmail, OrderCreateDto orderCreateDto);

    boolean updateOrder(Long id, OrderUpdateDto orderUpdateDto);

    void deleteOrder(Long id);

    OrderDto getOrderById(Long id);

    OrderDto getOrderByOrderItemId(Long itemId);

    PaginationPayload<OrderDto> getAllOrders(Integer pageNumber);

    List<OrderDto> getSearchOrders(String keyword);
}
