package be.intecbrussel.dao.implementation;

@Repository
@Transactional
public class Dao_CustomerOrderImpl implements Dao_CustomerOrder {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush(); //never had this in school!!
    }

}