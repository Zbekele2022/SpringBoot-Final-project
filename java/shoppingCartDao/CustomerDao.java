package shoppingCartDao;

import java.util.List;
import shoppingCartEntity.Customers;

public interface CustomerDao {

  //Customer Dao takes in everything from the Default Customer Service class,
  //before handing it off to the Default Customer Dao

  Object getCustomerID = null;

  List<Customers> fetchAllCustomers();

  List<Customers> fetchACustomers(String firstName, String lastName);

  List<shoppingCartEntity.Customers> fetchCustomerByFirstName(String firstName);

//  List<Customer> fetchMultipleCustomers(String firstName, String lastName);

  Customers createCustomers(String firstName, String lastName, String Address,String City,String phone);

  Customers updateCustomer(int customerPK, Customers updatedCustomers);

  Customers createCustomer(int customerPK, String firstName, String lastName, String address,
      String city, String phone);

  Customers updateCustomers(int customerPK, Customers updatedCustomers);




}