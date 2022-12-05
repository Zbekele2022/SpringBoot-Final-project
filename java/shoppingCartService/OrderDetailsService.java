package shoppingCartService;

import java.util.List;
import javax.validation.Valid;
import shoppingCartEntity.OrderDetails;

public interface OrderDetailsService {

  static List<OrderDetails> fetchOrderDetails(int updatePK, int orderDetailsFK) {
    // TODO Auto-generated method stub
    return null;
  }

  static List<shoppingCartEntity.OrderDetails> createOrderDetails(int orderId, int productFK,
      String updates) {
    // TODO Auto-generated method stub
    return null;
  }

  static List<OrderDetails> updateOrderDetails(int updatePK, @Valid OrderDetails updatedOrderDetails) {
    // TODO Auto-generated method stub
    return null;
  }

  OrderDetails saveOrderDetails(@Valid OrderDetails orderDetails);

  static List<OrderDetails> fetchOrderDetailsList(int orderDetailsID, int orderId) {
    // TODO Auto-generated method stub
    return null;
  }

  void deleteOrderDetailsById(int orderDetailsId);

  OrderDetails updateOrderDetailsById(OrderDetails orderDetails, int orderDetailsId);

  <OrderDetails> List<OrderDetails> fetchOrderDetails();



}
