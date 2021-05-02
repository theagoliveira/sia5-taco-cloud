package tacos.kitchen.messaging.kafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import tacos.Order;
import tacos.kitchen.KitchenUI;

@Component
public class OrderListener {

    @Autowired
    private KitchenUI ui;

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order) {
        ui.displayOrder(order);
    }

}
