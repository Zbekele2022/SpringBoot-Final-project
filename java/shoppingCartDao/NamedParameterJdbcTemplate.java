package shoppingCartDao;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import shoppingCartEntity.OrderDetails;
import shoppingCartEntity.Product;

public class NamedParameterJdbcTemplate {

  public List<Product> query(String sql, Map<String, Object> params, RowMapper rowMapper) {
    // TODO Auto-generated method stub
    return null;
  }

}
