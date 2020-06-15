package pl.kpro.demoprezentacyjne.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kpro.demoprezentacyjne.data.entity.Order;
import pl.kpro.demoprezentacyjne.data.entity.Product;
import pl.kpro.demoprezentacyjne.data.repository.OrderRepository;
import pl.kpro.demoprezentacyjne.data.repository.ProductRepository;
import pl.kpro.demoprezentacyjne.web.payload.request.NewOrderRequest;

import java.util.Optional;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Service
public class OrderService
{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository)
    {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void saveNew(NewOrderRequest newOrderRequest)
    {
        Order order = new Order();
        order.setAddress(newOrderRequest.getAddress());
        order.setEmail(newOrderRequest.getEmail());
        order.setPhoneNumber(newOrderRequest.getPhoneNumber());
        order.setZipCode(newOrderRequest.getZipCode());
        Optional<Product> product = productRepository.findById(newOrderRequest.getProductId());
        if(product.isPresent())
        {
            order.setProduct(product.get());
            orderRepository.saveAndFlush(order);
        }
        else
            product.orElseThrow();
    }
}
