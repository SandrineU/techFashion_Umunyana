package be.intecbrussel.dao;

public interface Dao_Customer {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customer_id);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String customer_username);
}
