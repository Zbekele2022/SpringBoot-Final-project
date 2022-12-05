package shoppingCartController;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import shoppingCartEntity.OrderDetails;


@Validated
@RequestMapping("/ShoppingCart/")
@OpenAPIDefinition(info = @Info(title = "OrderDetails"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
//Interface
public interface OrderDetailsController {

  //List<OrderDetails> fetchOrderDetails(int updatePK, int orderDetailsFK);

  List<OrderDetails> fetchOrderDetails(int updatePK, int orderDetailsID);


   // Save operation
   OrderDetails saveOrderDetails(OrderDetails orderDetails);

   // Read operation
   List<OrderDetails> fetchOrderDetailsList();

   // Update operation
   OrderDetails updateOrderDetails(OrderDetails orderDetails,
                               Long orderDetailsId);

   // Delete operation
   void deleteOrderDetailsByOrderDetailsID(Long orderDetailsID);
}




