package be.intecbrussel.dao.implementation;

@Repository
@Transactional
public class Dao_CustomerImpl implements Dao_Customer {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getCustomer_username());
        newUser.setPassword(customer.getCustomer_password());
        newUser.setEnabled(true);
        newUser.setCustomer_id(customer.getCustomer_id());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getCustomer_username());
        newAuthorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where customer_username = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

    public Customer getCustomerById(int customer_id){
        Session session = sessionFactory.getCurrentSession();

        return (Customer) session.get(Customer.class, customer_id);
    }

    public List<Customer> getAllCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");

        return (List<Customer>) query.list();
    }



}
