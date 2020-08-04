package be.intecbrussel.dao.implementation;

@Repository
@Transactional
public class Dao_CartImpl implements Dao_Cart {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cart_id){
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cart_id);
    }

    public void update(Cart cart){
        int cartId = cart.getCart_id();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGran_total(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    public Cart validate(int cart_id) throws IOException{
        Cart cart = getCartById(cart_id);
        if(cart == null || cart.getCart_items().size() == 0){
            throw new IOException(cart_id + "");
        }

        update(cart);
        return cart;
    }


}