package shoppingCartController;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import shoppingCartEntity.Customers;
import shoppingCartService.CustomerService;

@RestController

public class DefaultCustomerController implements CustomerController {

// Default Customer Controller takes information from the Customer Controller and then implements in.
  //Afterwards, it is then handed off to the Customer Service interface.

    @Autowired
    private CustomerService customerService;
@Override
public List<Customers> fetchAllCustomers() {
  return customerService.fetchAllCustomers();
}

@Override
public List<Customers> fetchACustomer(String firstName, String lastName) {
  return customerService.fetchACustomer(firstName, lastName);
}
@Override
public List<Customers> fetchCustomerByFirstName(String firstName) {
  return customerService.fetchCustomerByFirstName(firstName);}

@Override
public Customers createCustomers(String firstName, String lastName, String address, String city, String phone) {
  return customerService.createCustomer(firstName, lastName, address, city,phone);
}

@Override
public Customers updateCustomers(int customerPK, @Valid Customers updatedCustomer) {
  return customerService.updateCustomer(customerPK, updatedCustomer);
}

@Override
public Customers updateCustomer(int customerPK, Customers updatedCustomer) {
  // TODO Auto-generated method stub
  return null;
}







}

