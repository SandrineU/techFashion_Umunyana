package be.intecbrussel.controller;

@Controller
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String getProductos(Model model) {
        List<Producto> lista_productos = productService.getProductList();
        model.addAttribute("lista_productos", lista_productos);
        return "productos";
    }

    @RequestMapping("/productoDetalles/{product_id}")
    public String detallesProducto(@PathVariable int product_id, Model model) throws IOException {
        Producto producto = productService.getProductById(product_id);
        model.addAttribute(producto);

        return "productoDetalles";
    }
}
