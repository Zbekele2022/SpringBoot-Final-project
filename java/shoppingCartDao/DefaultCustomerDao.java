package shoppingCartDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import shoppingCartEntity.Customers;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  //Lastly, we take everything from the Customer Dao interface and implement it all here.

  @Override
  public List<Customers> fetchAllCustomers() {
    log.info("In customerdao.fetchAllCustomers");

    //sql code for the command
      // @formatter:off
      String sql = ""
          +"SELECT * "
          + "FROM customers;";
      // @formatter:on

    //creates a map of objects and then returns with a builder throwing together all of
    //the information you want to output from the sql database.
      Map<String, Object> params = new HashMap<>();
      return jdbcTemplate.query(sql,
          new RowMapper<Customers>() {
            @Override
   public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
              // @formatter:off
              return Customers.builder()
                  .customerPK(rs.getInt("customers_pk"))
                  .firstName(rs.getString("first_name"))
                  .lastName(rs.getString("last_name"))
                  .address(rs.getString("address"))
                  .city(rs.getString("city"))
                  .phone(rs.getString("phone"))
                  .build();
              // @formatter:on
            }});
    }

  public class CustomersResultSetExtractor implements ResultSetExtractor<Customers> {
    @Override
  public Customers extractData(ResultSet rs)
        throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
      return Customers.builder()
          .customerPK(rs.getInt("customers_pk"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .address(rs.getString("address"))
          .city(rs.getString("city"))
          .phone(rs.getString("phone"))
          .build();
      // @formatter:on
    }
  }

  // allows customer to be called from other databases without being allowed to edit the Customer Database,
  //just read the one customer pk they entered in to see.
  protected Customers fetchCustomerByPK(int customerPK) {
    //@formatter:off
    String sql = ""
          +"SELECT * "
          + "FROM customers "
          + "WHERE customer_pk = :customer_pk";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("customer_pk", customerPK);

    return jdbcTemplate.query(sql,params, new CustomersResultSetExtractor());
  }

    // Retrieve data from database and return to service layer
  public List<CustomerDao> fetchACustomers(String firstName, String lastName, String address, String city, String phone) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customer "
        + "WHERE first_name = :first_name AND last_name = :last_name";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    params.put("address",address);
    params.put("city",city);
    params.put("Phone",phone);

    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Customers.builder()
                .customerPK(rs.getInt("customers_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .address(rs.getString("address"))
                .city(rs.getString("city"))
                .phone(rs.getString("phone"))
                .build();
         // @formatter:on
          }});

  }

  @Override
  public List<Customers> fetchCustomerByFirstName(String firstName) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customer "
        + "WHERE first_name = :first_name";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);

    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Customers.builder()
                .customerPK(rs.getInt("customer_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .address(rs.getString("address"))
                .city(rs.getString("city"))
                .phone(rs.getString("phone"))
                .build();
         // @formatter:on
          }});
  }

  public Customers createCustomer(String firstName, String lastName, String address, String city,String phone) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into customers "
        + "(first_name, last_name, address, city, phone)"
        + "VALUES (:first_name, :last_name,:address,:city, :phone)" ;
    sqlparams.source.addValue("first_name", firstName);
    sqlparams.source.addValue("last_name", lastName);
    sqlparams.source.addValue("address", address);
    sqlparams.source.addValue("city",city);
    sqlparams.source.addValue("phone", phone);


    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Customers.builder()
        .customerPK(keyHolder.getKey().intValue())
        .firstName(firstName)
        .lastName(lastName)
        .address(address)
        .city(city)
        .phone(phone)
        .build();
  }

  //This is needed in order to fully implement the create function.
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }


  @Override
  public Customers updateCustomer(int customerPK, Customers updatedCustomer) {
    // @formatter:off
    String sql = ""
        + "UPDATE customers "
        + "SET "
        + "first_name = :first_name, "
        + "last_name = :last_name, "
        + "address = :address,"
        + "city = :city,"
        + "phone = :phone"
        + "WHERE customer_pk = :customer_pk;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("first_name", updatedCustomer.getFirstName());
    params.put("last_name", updatedCustomer.getLastName());
    params.put("address",updatedCustomer.getAddress());
    params.put("city",updatedCustomer.getCity());
    params.put("phone", updatedCustomer.getPhone());
    params.put("customer_pk", customerPK);

  //  jdbcTemplate.update(sql, params);
      if (jdbcTemplate.update(sql, params) == 0) {
       throw new NoSuchElementException("update failed :( ");
      }
    return Customers.builder()
        .customerPK(customerPK)
        .firstName(updatedCustomer.getFirstName())
        .lastName(updatedCustomer.getLastName())
        .address(updatedCustomer.getAddress())
        .city(updatedCustomer.getCity())
        .phone(updatedCustomer.getPhone())
        .build();

  }
  @Override
  public List<Customers> fetchACustomers(String firstName, String lastName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Customers createCustomers(String firstName, String lastName, String Address, String City,
      String phone) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Customers updateCustomers(int customerPK, Customers updatedCustomers) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Customers createCustomer(int customerPK, String firstName, String lastName, String address,
      String city, String phone) {
    // TODO Auto-generated method stub
    return null;
  }
 }



