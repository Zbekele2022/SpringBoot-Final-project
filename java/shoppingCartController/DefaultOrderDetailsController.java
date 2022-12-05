package shoppingCartController;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import shoppingCartEntity.OrderDetails;
import shoppingCartService.OrderDetailsService;

@RestController

public class DefaultOrderDetailsController implements OrderDetailsController {

  @Autowired
  private OrderDetailsService orderDetailsService;

  @PostMapping("/orderDetails")

 public OrderDetails saveOrderDetails(@Valid
      @RequestBody OrderDetails orderDetails) {
   return orderDetailsService.saveOrderDetails(orderDetails);
  }

  //Read operation
  @GetMapping("/orderDetails")
 public List<OrderDetails> fetchOrderDetailsList(int orderDetailsID,int orderId) {
    return OrderDetailsService.fetchOrderDetailsList(orderDetailsID, orderId);

  }
  //Update operation
  @PutMapping("/orderDetails/{id}")
  public OrderDetails updateOrderDetails(@RequestBody OrderDetails orderDetails,
         @PathVariable("id") int orderDetailsId) {
    return orderDetailsService.updateOrderDetailsById(orderDetails,orderDetailsId);
     }

   //Delete operation
  @DeleteMapping("/orderDetails/{id}")
  public String deleteorderDetailsById(@PathVariable("id") int orderDetailsId) {
    orderDetailsService.deleteOrderDetailsById(orderDetailsId);
    return "Deleted Successfully";


  }

  @Override
  public List<OrderDetails> fetchOrderDetails(int updatePK, int orderId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderDetails> fetchOrderDetailsList() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OrderDetails updateOrderDetails(OrderDetails orderDetails, Long orderDetailsId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteOrderDetailsByOrderDetailsID(Long orderDetailsID) {
    // TODO Auto-generated method stub
    
  }
  }



