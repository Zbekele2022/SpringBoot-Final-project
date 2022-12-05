package shoppingCartController;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.core.status.Status;
import lombok.extern.slf4j.Slf4j;
import shoppingCartEntity.Order;
import shoppingCartService.OrderService;


@RestController
@Slf4j
public class DefaultOrderController implements OrderController {

  @Autowired
  private OrderService orderService;


  @Override
  public List<Order> fetchAllOrders() {
  return orderService.fetchAllorderOrders();
  }
  @Override
  public List<Order> fetchOrder(int orderFK) {
    return orderService.fetchOrder(orderFK);
  }

//  @Override
//  public Order createOrder(int orderNumber, Date orderDate, Date requiredDate,Date shippedDate,
//              String status, String comments, int customerNumber);{
//                return orderService.createOrder(orderNumber, orderDate, requiredDate,shippedDate,
//                    comments, customerNumber);
//}
  @Override
  public Order updateOrder(int orderNumber, Order updatedOrder) {
    return orderService.updateOrder(updatedOrder);
  }
//  @Override
//  public List<Order> fetchOrderAllOrders(Status status) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//  @Override
//  public Order createOrder(int customerFK, String description, Status status,
//      BigDecimal estimatedCost, BigDecimal actualCost) {
//    // TODO Auto-generated method stub
//    return null;
 // }
  @Override
  public void deleteOrder(int deleteId) {
    // TODO Auto-generated method stub

  }
@Override
public List<Order> fetchAllOrder() {
  // TODO Auto-generated method stub
  return null;
}
@Override
public List<Order> fetchOrderAllOrders(Status status) {
  // TODO Auto-generated method stub
  return null;
}
@Override
public Order createOrder(int customerFK, String description, Status status,
    BigDecimal estimatedCost, BigDecimal actualCost) {
  // TODO Auto-generated method stub
  return null;
}

  }




