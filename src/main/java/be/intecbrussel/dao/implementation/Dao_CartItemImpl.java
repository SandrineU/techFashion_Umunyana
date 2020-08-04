package be.intecbrussel.dao.implementation;

@Repository
@Transactional
public class Dao_CartItemImpl implements Dao_CartItem{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        if(cartItem.getCantidad() > 1) {
            cartItem.setCantidad(cartItem.getCantidad()-1);
            cartItem.setPrecio_total(cartItem.getProducto().getPrecio()*cartItem.getCantidad());
            session.saveOrUpdate(cartItem);
        }
        else{
            session.delete(cartItem);
        }

        session.flush();
    }

    public void removeAllCartItems(Cart cart){
        Session session = sessionFactory.getCurrentSession();
        List<CartItem> cartItems = cart.getCart_items();
        for (CartItem item : cartItems){
            session.delete(item);
        }
        session.flush();
    }

    public CartItem getCartItemByProductId(int producto_id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where producto_id = ?");
        query.setInteger(0, producto_id);
        session.flush();

        return (CartItem) query.uniqueResult();
    }
}