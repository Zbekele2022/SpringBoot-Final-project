package shoppingCartDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import shoppingCartEntity.Order;

public interface OrderDao {

  List<Order> fetchAllOrders();

  List<shoppingCartEntity.Order> fetchAOrder(int orderFK);

  public Order createOrder(int orderFK,int customerFK,
      Date orderDate, Date requiredDate, Date shippedDate, String status, String comments);


  public Order updateOrder(int orderPK, Order updatedItem);

  Order mapRow(ResultSet rs, int rowNum) throws SQLException;
}
