package tacos.messaging;

import tacos.Order;

public interface OrderMessagingService {

    String convertAndSendOrder(Order order);

}
