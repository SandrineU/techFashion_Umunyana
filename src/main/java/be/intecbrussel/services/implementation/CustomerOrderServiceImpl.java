package be.intecbrussel.services.implementation;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private Dao_CustomerOrder dao_customerOrder;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        dao_customerOrder.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cart_id) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cart_id);
        List<CartItem> cartItems = cart.getCart_items();

        for (CartItem item : cartItems){
            grandTotal += item.getPrecio_total();
        }

        return grandTotal;
    }
}