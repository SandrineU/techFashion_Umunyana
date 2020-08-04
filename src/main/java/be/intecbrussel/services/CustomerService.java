package be.intecbrussel.services;

public class CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customer_id);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String customer_username);
}
