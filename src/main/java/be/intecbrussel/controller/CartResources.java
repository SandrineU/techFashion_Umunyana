package be.intecbrussel.controller;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{cart_id}")
    public @ResponseBody
    Cart getCartById(@PathVariable(value = "cart_id") int cart_id){
        return cartService.getCartById(cart_id);
    }

    @RequestMapping(value = "/add/{producto_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "producto_id") int producto_id, @AuthenticationPrincipal User active_user){
        Customer customer = customerService.getCustomerByUsername(active_user.getUsername());
        Cart cart = customer.getCart();
        Producto producto = productService.getProductById(producto_id);
        List<CartItem> cart_items = cart.getCart_items();

        for (int i=0; i < cart_items.size(); i++){
            if(producto.getProducto_id() == cart_items.get(i).getProducto().getProducto_id()){
                CartItem cartItem = cart_items.get(i);
                cartItem.setCantidad(cartItem.getCantidad() + 1);
                cartItem.setPrecio_total(producto.getPrecio()*cartItem.getCantidad());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProducto(producto);
        cartItem.setCantidad(1);
        cartItem.setPrecio_total(producto.getPrecio()*cartItem.getCantidad());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{producto_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "producto_id") int producto_id) {
        CartItem cartItem = cartItemService.getCartItemByProductId(producto_id);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cart_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cart_id") int cart_id){
        Cart cart = cartService.getCartById(cart_id);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors (Exception ex){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors (Exception ex){

    }
}
