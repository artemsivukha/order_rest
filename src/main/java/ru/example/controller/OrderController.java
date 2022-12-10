package ru.example.controller;

import org.springframework.web.bind.annotation.*;
import ru.example.model.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private final List<OrderDto> orders;
    public OrderController() {
        orders = new ArrayList<>();
    }

    @GetMapping
    public List<OrderDto> getOrders() {
        for (int i = 0; i < orders.size(); ++i) {
            if (orders.size() != 0) {
                return orders;
            }
        }
        return null;
        // тут хочу вывести надпись "На данный момент заказов не существует", но не понял какой использовать метод
    }

    @GetMapping("{id}")
    public OrderDto getOrder(@PathVariable long id) {
        OrderDto orderDtoResult = null;
        for (int i = 0; i < orders.size(); ++i) {
            OrderDto orderDto = orders.get(i);
            if (orderDto.getId() == id) {
                return orderDto;
            }
        }
        throw new RuntimeException("Заказ не найден");
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderInput) {
        for (int i = 0; i < orders.size(); ++i) {
            OrderDto order = orders.get(i);
            if (orderInput.getId() == order.getId()) {
                throw new RuntimeException("Заказ c таким ID уже существует");
            }
        }
        LocalDateTime createDate = LocalDateTime.now();
        orderInput.setCraeteDate(createDate);
        orders.add(orderInput);
        // хотел, чтобы тут вместо declineDate = null выводило надпись какую-нибудь, типо "Заказ активен"
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable long id) {
        for (int i = 0; i < orders.size(); ++i) {
            OrderDto order = orders.get(i);
            if (order.getId() == id) {
                LocalDateTime declineDate = LocalDateTime.now();
                order.setDeclineDate(declineDate);
                return;
            }
        }
        throw new RuntimeException("Заказ не найден");
    }
}
