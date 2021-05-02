package tacos.messaging;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import tacos.Order;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {

    @Autowired
    private JmsTemplate jms;

    @Override
    @GetMapping("/convertAndSend/order")
    public String convertAndSendOrder(Order order) {
        jms.convertAndSend(order, this::addOrderSource);
        return "Convert and sent order";
    }

    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SOURCE", "WEB");
        return message;
    }

}
