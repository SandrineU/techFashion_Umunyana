package be.intecbrussel.controller;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User active_user) {
        Customer customer = customerService.getCustomerByUsername(active_user.getUsername());
        int cart_id = customer.getCart().getCart_id();

        return "redirect:/customer/cart/" + cart_id;
    }

    @RequestMapping("/{cart_id}")
    public String getCartRedirect(@PathVariable(value = "cart_id")int cart_id, Model model) {
        model.addAttribute(cart_id);

        return "carroCompras";
    }

}
