/* package tacos.kitchen.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import tacos.Order;
import tacos.kitchen.OrderReceiver;

@Component
public class JmsOrderReceiver implements OrderReceiver {

    @Autowired
    private JmsTemplate jms;

    @Override
    public Order receiveAndConvertOrder() {
        return (Order) jms.receiveAndConvert();
    }

}
 */