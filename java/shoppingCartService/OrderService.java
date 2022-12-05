package shoppingCartService;

import java.util.List;
import shoppingCartEntity.Order;

public interface OrderService {

  // to save new order
  public Order saveOrder(Order order);

  //To update order
  public Order updateOrder(Order order);

  //To fetch all orders from database

  public List<Order> findAllOrders();

  // To delete orders
  public void deleteOrder(int orderId);

  public List<Order> fetchAllorderOrders();

  public List<Order> fetchOrder(int orderFK);








}
