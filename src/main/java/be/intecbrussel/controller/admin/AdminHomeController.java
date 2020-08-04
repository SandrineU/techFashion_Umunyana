package be.intecbrussel.controller.admin;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminHomePage() {
        return "admin";
    }

    @RequestMapping("/inventario")
    public String inventario(Model model) {
        List<Producto> lista_productos = productService.getProductList();
        model.addAttribute("lista_productos", lista_productos);

        return "productoInventario";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);
        return "adminListaUsuarios";
    }
}
