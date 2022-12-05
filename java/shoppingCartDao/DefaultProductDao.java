package shoppingCartDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import shoppingCartEntity.Product;

@Component
  @Slf4j
  public class DefaultProductDao implements ProductDao {
    
  @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
        //Retrieve data from database and returns to service layer
    //Implements the ProductDao interface, and begins to finish all of the commands up before it
    //sends them to swagger potentially when called upon. 
      
  @Override 
    public List<Product> fetchAllProduct() {                                              
      log.info("In product.dao.fetchAllProduct");
      
          // @formatter:off
          String sql = ""
              + "SELECT * "
              + "FROM product ";
          // @formatter:on
          
          Map<String, Object> params = new HashMap<>();
          return jdbcTemplate.query(sql, params,
              new RowMapper<Product>() {
          }
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                  // @formatter:off
               return Product.builder()
               .productID(rs.getInt("product_pk"))
               .catagoryFK(rs.getInt("catagory_fk"))
               .description(rs.getString("Description"))
               .productName(rs.getString("product Name"))
               .price(rs.getDouble("price"))
               .quantityInStock(.getInt("Quantity in Stock"))
               .build();
           // @formatter:on
            }
            
          private Object getInt(String string) {
              // TODO Auto-generated method stub
              return null;
          }

          });


@Override
public List<Product> fetchAllProductByProduct(int productFK) {                       
  // @formatter:off
  String sql = ""
      + "SELECT * "
      + "FROM product "
      + "WHERE product_fk = :product_fk ";
  // @formatter:on
  
  Map<String, Object> params = new HashMap<>();
  params.put("product_fk", productFK);
  
  return jdbcTemplate.query(sql, params,
      new RowMapper<>() {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
          return Product.builder()
             .productID(rs.getInt("product_pk"))
             .catagoryFK(rs.getInt("catagory_fk"))
             .description(rs.getString("Description"))
             .productName(rs.getString("product Name"))
             .price(rs.getDouble("price"))
             .quantityInStock(.getInt("Quantity in Stock"))
             .build();
          // @formatter:on
        }
  });    


@Override
public Product updateProduct(int productPK, Product updatedProduct) {
  // @formatter:off
  String sql = ""
      + "UPDATE product "
      + "SET "
      + "product_fk = :product_fk, "
      + "catagoryFK = :serial_number, "
  + " description =: description,"
      + "productName = :product name, "
      + "price = :price, "
      + "quantityInStock = :quantity in stock "
      + "WHERE product_pk = :product_pk;";
  // @formatter:on
  
  Map<String, Object> params = new HashMap<>();
  params.put("product_fk", updatedProduct.getProductFK());
  params.put("catagoryID", updatedProduct.getCatagoryID());
  params.put("description", updatedProduct.getDescription());
  params.put("productName", updatedProduct.getProductName());
  params.put("price", updatedProduct.getPrice().toString());
  params.put("product_pk", productPK);
  
 // jdbcTemplate.update(sql, params);
 
  //can be done on creates or inserts to check everything works properly
    if (jdbcTemplate.update(sql, params) == 0) {
    throw new NoSuchElementException("update failed :( ");
   }
  return Product.builder()
             .productID(rs.getInt("product_pk"))
             .catagoryFK(rs.getInt("catagory_fk"))
             .description(rs.getString("Description"))
             .productName(rs.getString("product Name"))
             .price(rs.getDouble("price"))
             .quantityInStock(.getInt("Quantity in Stock"))
             .build();
  
}
}
@Override
public List<Product> fetchProduct(ProductType type) {                               
  // @formatter:off
  String sql = ""
      + "SELECT * "
      + "FROM product "
      + "WHERE type = :type ";
  // @formatter:on
  
  Map<String, Object> params = new HashMap<>();
  params.put("type", type.toString());
  
  return jdbcTemplate.query(sql, params,
      new RowMapper<>() {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
          return Product.builder()
             .productID(rs.getInt("product_pk"))
             .catagoryFK(rs.getInt("catagory_fk"))
             .description(rs.getString("Description"))
             .productName(rs.getString("product Name"))
             .price(rs.getDouble("price"))
             .quantityInStock(.getInt("Quantity in Stock"))
             .build();
          // @formatter:on
        }
  });    
}
}


  
    

