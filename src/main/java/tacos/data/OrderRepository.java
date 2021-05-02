package tacos.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import tacos.Order;
import tacos.User;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

    Order findByDeliveryName(String deliveryName);

}
