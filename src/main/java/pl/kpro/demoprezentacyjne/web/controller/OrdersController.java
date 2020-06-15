package pl.kpro.demoprezentacyjne.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kpro.demoprezentacyjne.data.entity.Order;
import pl.kpro.demoprezentacyjne.data.repository.OrderRepository;
import pl.kpro.demoprezentacyjne.data.service.OrderService;
import pl.kpro.demoprezentacyjne.web.payload.response.NewOrderResponse;
import pl.kpro.demoprezentacyjne.web.payload.request.NewOrderRequest;

import java.util.Optional;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Controller
@RequestMapping("/order")
public class OrdersController
{
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderRepository orderRepository, OrderService orderService)
    {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping
    public String indexOrders(Model model)
    {
        model.addAttribute("orders",orderRepository.findAll());
        return "orders";
    }

    @GetMapping(path="/{orderId}")
    public String orderDetails(Model model, @PathVariable Long orderId)
    {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent())
            model.addAttribute("order", order.get());
        else
            return "redirect:/product/";
        return "order";
    }

    @GetMapping(path="/new")
    public String newOrder(Model model, @RequestParam Long id)
    {
        model.addAttribute("order", new NewOrderResponse(id));
        return "newOrder";
    }

    @PostMapping(path="/new")
    public String newOrder(NewOrderRequest newOrderRequest)
    {
        orderService.saveNew(newOrderRequest);
        return "redirect:/order";
    }
}
