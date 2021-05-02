/* package tacos.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import tacos.Order;

// // TEST KAFKA
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import tacos.data.OrderRepository;


// @RestController
@Service
public class KafkaOrderMessagingService implements OrderMessagingService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.sendDefault(order);
    }

    // // TEST KAFKA
    // @Autowired
    // private OrderRepository orderRepository;

    // @GetMapping("/kafkatest")
    // public void sendOrderTest() {
    //     Order orderTest = orderRepository.findByDeliveryName("Tico");
    //     kafkaTemplate.sendDefault(orderTest);
    }
}
 */