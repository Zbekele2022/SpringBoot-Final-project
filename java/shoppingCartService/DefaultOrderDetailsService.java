package shoppingCartService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import shoppingCartEntity.OrderDetails;

@RestController
public class DefaultOrderDetailsService implements OrderDetailsService {

  @Autowired
  private OrderDetailsService orderDetailsService;

  public List<OrderDetails> fetchOrderDetails(int updatePK, int orderFK) {
    return OrderDetailsService.fetchOrderDetails(updatePK, orderFK);
  }
  public <OrderDetails> List<OrderDetails> fetchOrderDetails() {
    return orderDetailsService.fetchOrderDetails();

//  @Override
//  public OrderDetails createOrderDetails(int updatePK, int orderFK,
//      int productFK, String updates) {
//    return orderDetailsService.createOrderDetails(updatePK, orderFK, productFK, updates);
//  }
//
  public List<shoppingCartEntity.OrderDetails> createOrderDetails(int orderFK,
  int productFK, String updates) {
  return OrderDetailsService.createOrderDetails(orderFK, productFK, updates);
  }

  public OrderDetails updateOrderDetails(int updatePK,
      @Valid OrderDetails updatedOrderDetails) {
    return orderDetailsService.updateOrderDetails(updatePK, updatedOrderDetails);
  }
  @Override
  public shoppingCartEntity.OrderDetails saveOrderDetails(
      shoppingCartEntity.@Valid OrderDetails orderDetails) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public void deleteOrderDetailsById(int orderDetailsId) {
    // TODO Auto-generated method stub
    
  }
  @Override
  public shoppingCartEntity.OrderDetails updateOrderDetailsById(
      shoppingCartEntity.OrderDetails orderDetails, int orderDetailsId) {
    // TODO Auto-generated method stub
    return null;
  }
}
