package be.intecbrussel.controller;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cart_id}")
    public String createOrder(@PathVariable("cart_id") int cart_id){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cart_id);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customer.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?id="+cart_id;
    }
}
