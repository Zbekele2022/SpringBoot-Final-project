package shoppingCartDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.tree.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import shoppingCartEntity.Order;

@Component
@Slf4j

public class DefaultOrderDao implements OrderDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public List<Order> fetchAllOrders() {
    log.info("In orderDao.fetchAllOrder()");

    // @formatter:off
    String sql = ""
        +"SELECT * "
        + "FROM service_line_item;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    return jdbcTemplate.query(sql, params,
    new RowMapper<Order>() {
     
    @Override
   public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return Order.builder()
                .categoryPK(rs.getInt("categorypk"))
                .orderFK(rs.getInt("order_fk"))
                .orderDetailsFK(rs.getInt("orderDetails_fk"))
                .customerFK(rs.getInt("customer_fk"))
                .build();
            // @formatter:on
          }});
    @Override
    public List<Order> fetchAOrder(int orderFK) {
      // @formatter:off
      String sql = ""
          + "SELECT * "
          + "FROM order "
          + "WHERE order_fk = :order_fk ";
      // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("order_fk", orderFK);

    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

    }
    
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
            return Order.builder()
                .orderPK(rs.getInt("order_pk"))
                .customerFK(rs.getInt("customer_fk"))
                .orderDate(rs.getDate("order_date"))
                .requiredDate(rs.getDate("required_date"))
                .shippedDate(rs.getDate("shipped_date"))
                .status(rs.getStatus("status"))
                .comments(rs.getComments("comments"))
                .build();
            // @formatter:on
}
    @Override
    public Order createOrder(int orderFK, int customerFK, Date orderDate, Date requiredDate,
        Date shippedDate, String status, String comments) {
      return null;
    }
    @Override
    public Order updateOrder(int orderPK, Order updatedItem) {
      return null;
    }
    }

