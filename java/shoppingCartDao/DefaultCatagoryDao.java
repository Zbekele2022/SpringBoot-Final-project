package shoppingCartDao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import shoppingCartEntity.OrderDetails;


@Component
@Slf4j
public class DefaultCatagoryDao implements CatagoryDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<OrderDetails> fetchOrderDetails(int updatPK, int orderID) {
    log.info("DAO: updatePK={}, orderFK={}, updatePK, orderFK");

    // @formatter:off
       String sql = ""
           + "SELECT * "
           + "FROM orderDetails "
           + "WHERE orderDetails = :update_pk AND order_fk = :order_fk";
       // @formatter:on

       Map<String, Object> params = new HashMap<>();
       Object updatePK;
      params.put("update_pk", updatePK);
       Object orderFK;
      params.put("order_fk", orderFK);

       return jdbcTemplate.query(sql, params,
           new RowMapper<>() {
             @Override
    public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
           return OrderDetails.builder()
                   .updatePK(rs.getInt("update_pk"))
                   .orderID(rs.getInt("order_fk"))
                   .productID(rs.getInt("product_fk"))
                   .updates(rs.getString("updates"))
                   .updateTime(rs.getTimestamp("update_time"))
                   .build();
           // @formatter:on

            }});
  }

  @Override
  public OrderDetails createOrderDetails(int orderFK, int productFK, String updates) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OrderDetails updateOrderDetails(int updatePK, OrderDetails updatedOrderDetails) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderDetails> fetchAllOrderDetails() {
    // TODO Auto-generated method stub
    return null;
  }


}
