package be.intecbrussel.services.implementation;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private Dao_Cart dao_cart;

    public Cart getCartById(int cart_id){
        return dao_cart.getCartById(cart_id);
    }

    public void update(Cart cart){
        dao_cart.update(cart);
    }

    public Cart validate(int cart_id) throws IOException {
        return dao_cart.validate(cart_id);
    }
}