package tacos.kitchen.messaging.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import tacos.Order;
import tacos.kitchen.OrderReceiver;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

    @Autowired
    private RabbitTemplate rabbit;

    @Override
    public Order receiveOrder() {
        return rabbit.receiveAndConvert(
            "tacocloud.order.queue",
            new ParameterizedTypeReference<Order>() {
            }
        );
    }

}
