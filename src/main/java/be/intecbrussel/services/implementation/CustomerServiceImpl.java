package be.intecbrussel.services.implementation;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    Dao_Customer dao_customer;

    public List<Customer> getAllCustomers() {
        return dao_customer.getAllCustomers();
    }

    public Customer getCustomerById(int customer_id) {
        return dao_customer.getCustomerById(customer_id);
    }

    public void addCustomer(Customer customer) {
        dao_customer.addCustomer(customer);
    }

    public Customer getCustomerByUsername(String customer_username) {
        return dao_customer.getCustomerByUsername(customer_username);
    }
}