package be.intecbrussel.controller.admin;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    private Path path;
    private Product_Category_List lista_categorias = new Product_Category_List();
    @Autowired
    private ProductService productService;

    @RequestMapping("/inventario/agregar")
    public String productoAgregar(Model model) {
        Producto producto = new Producto();
        producto.setCondicion("Nuevo");
        model.addAttribute("lista_categoria", lista_categorias.categorias);
        model.addAttribute(producto);

        return "productoAgregar";
    }

    @RequestMapping(value = "/inventario/agregar" , method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("producto") Producto producto,
                                 BindingResult result, HttpServletRequest request, Model model) {
        model.addAttribute("lista_categoria", lista_categorias.categorias);

        if(result.hasErrors()) {
            return "productoAgregar";
        }
        productService.addProduct(producto);
        MultipartFile producto_imagen = producto.getImagen();
        String root_directory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(root_directory + "\\WEB-INF\\resources\\product_images\\" + producto.getProducto_id() + ".png");

        if (producto_imagen != null && !producto_imagen.isEmpty()) {
            try {
                producto_imagen.transferTo(new File(path.toString()));
                /**
                 Scale Image to fit ascpect ratio IF NECESSARY...
                 //Convert it it to resize it
                 // Retrieve Image
                 BufferedImage buffer = ImageIO.read(new File(path.toString()));
                 int image_type = buffer.getType();
                 BufferedImage bufferNew = image_resizer.scale(buffer, image_type, 700, 600, 1.4, 1.4);
                 File outputfile = new File(path.toString());
                 ImageIO.write(bufferNew, "png", outputfile); // Write the Buffered Image into an output file
                 **/
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("La imagen del producto no pudo ser guardada.\n" + e);
            }
        }
        return "redirect:/admin/inventario";
    }

    @RequestMapping("/inventario/editar/{product_id}")
    public String editProduct(@PathVariable("product_id") int id, Model model) {
        Producto producto = productService.getProductById(id);
        model.addAttribute("lista_categoria", lista_categorias.categorias);
        model.addAttribute("producto", producto);

        return "productoEditar";
    }

    @RequestMapping(value = "/inventario/editar", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("producto") Producto producto,
                                  BindingResult result, Model model, HttpServletRequest request) throws RuntimeException {
        model.addAttribute("lista_categoria", lista_categorias.categorias);
        if (result.hasErrors()) {
            return "productoEditar";
        }
        MultipartFile productImage = producto.getImagen();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\product_images\\" + producto.getProducto_id() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("La imagen del producto no pudo ser guardada.\n" + e);
            }
        }
        productService.editProduct(producto);

        return "redirect:/admin/inventario";
    }

    @RequestMapping("/inventario/eliminar/{product_id}")
    public String deleteProduct(@PathVariable("product_id") int product_id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\product_images\\" + product_id + ".png");
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Producto producto = productService.getProductById(product_id);
        productService.deleteProduct(producto);

        return "redirect:/admin/inventario";
    }
}
