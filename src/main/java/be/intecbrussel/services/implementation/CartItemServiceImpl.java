package be.intecbrussel.services.implementation;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private Dao_CartItem dao_cartItem;

    public void addCartItem(CartItem cartItem){
        dao_cartItem.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        dao_cartItem.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        dao_cartItem.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int producto_id){
        return dao_cartItem.getCartItemByProductId(producto_id);
    }

}