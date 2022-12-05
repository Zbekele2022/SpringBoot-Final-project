package shoppingCartService;

import java.util.List;
import shoppingCartEntity.Customers;


public interface CustomerService {

  // to save new Customer
  public Customers saveCustomer(Customers Customer);

  //To update Customer
  public Customers updateCustomer(Customers Customer);

  //To fetch all Customers from database

  public List<Customers> findAllCustomers();

  // To delete Customers
  public Customers deleteCustomers(int CustomerId);

  //public Customer createCustomer(String firstName, String lastName, String phone);

//Customer Service takes in from the Default Customer Controller into the now customer service interface.
  //From here, it then gets handed off to the Default Customer Service Class.

  List<Customers> fetchAllCustomers();

  List<Customers> fetchACustomer(String firstName, String lastName);

  List<Customers> fetchCustomerByFirstName(String firstName);

  Customers createCustomer(String firstName, String lastName, String address, String city,String phone);

  Customers updateCustomer(int customerPK, Customers updatedCustomer);

  List<Customers> fetchCustomer(String customer);

  Customers updateCustomers(int customerPK, Customers updatedCustomer);

  Customers createCustomer(int customerPK, String firstName, String lastName, String address,
      String City, String phone);

}

