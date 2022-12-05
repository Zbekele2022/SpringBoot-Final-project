package shoppingCartDao;

import java.util.List;
import shoppingCartEntity.OrderDetails;

public interface CatagoryDao {

  List<OrderDetails> fetchOrderDetails(int updatePK, int orderFK);

  List<OrderDetails> fetchAllOrderDetails();

//  OrderDetails createOrderDetails(int updatePK, int orderFK, int productFK,
//      String updates);

  OrderDetails createOrderDetails(int orderFK, int productFK,
      String updates);

  OrderDetails updateOrderDetails(int updatePK, OrderDetails updatedOrderDetails);
}
