package shoppingCartService;


import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import shoppingCartDao.CustomerDao;
import shoppingCartEntity.Customers;


@Slf4j
@Service
public class DefaultCustomerService implements CustomerService {

  @Autowired
  private CustomerDao customerDao;



  //Default Customer Service class implements everything from the Customer Service interface.
  //Next it all get's handed off to the Customer Data Access Object (Dao).

  @Override
  public List<Customers> fetchAllCustomers() {
    List<Customers> customer = customerDao.fetchAllCustomers();
    if(customer.isEmpty()) {
    String msg = String.format("We have no customers :(");
    throw new NoSuchElementException(msg);
    }

   // Collections.sort((List<Employee>) employees);
    return customer;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Customers> fetchACustomer(String firstName, String lastName) {
    log.info("Fetch Customer in service layer");

    List<Customers> customer = customerDao.fetchACustomers(firstName, lastName);
    if(customer.isEmpty()) {
    String msg = String.format("No customer was found with firstName=%s and lastName=%s", firstName, lastName);
    throw new NoSuchElementException(msg);
    }
       return customer;
  }
    /**
     *
     * @param CustomerRequest
     * @return
     */
   // private List<Option> getOption(CustomerRequest CustomerRequest) {
     // return CustomerDao.fetchOptions(CustomerRequest.getOptions());
    //}

    @Override
    public List<Customers> fetchCustomerByFirstName(String firstName) {
      return customerDao.fetchACustomers(firstName, firstName);
    }
  @Override
  public Customers createCustomer(int customerPK, String firstName,String lastName, String address, String City, String phone) {
    log.info("Create customers in service layer");
    return customerDao.createCustomer(customerPK, firstName, lastName, address, City, phone);
  }

  @Override
  public Customers updateCustomers(int customerPK,Customers updatedCustomer) {
    log.info("updates Customer in service layer");
    return customerDao.updateCustomer(customerPK, updatedCustomer);
  }

  @Override
  public Customers saveCustomer(Customers Customer) {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public Customers deleteCustomers(int CustomerId) {
    return null;

  }

  @Override
  public Customers updateCustomer(int customerPK, Customers updatedCustomer) {
    // TODO Auto-generated method stub
    return null;
  }



  @Override
  public List<Customers> findAllCustomers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Customers> fetchCustomer(String customer) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Customers createCustomer(String firstName, String lastName, String address, String city,
      String phone) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Customers updateCustomer(Customers Customer) {
    // TODO Auto-generated method stub
    return null;
  }

}


