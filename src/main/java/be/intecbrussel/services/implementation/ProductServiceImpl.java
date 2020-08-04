package be.intecbrussel.services.implementation;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Dao_producto dao_producto;

    public List<Producto> getProductList() {
        return dao_producto.getProductList();
    }

    public Producto getProductById(int id) {
        return dao_producto.getProductById(id);
    }

    public void addProduct(Producto producto) {
        dao_producto.addProduct(producto);
    }

    public void editProduct(Producto producto) {
        dao_producto.editProduct(producto);
    }

    public void deleteProduct(Producto producto) {
        dao_producto.deleteProduct(producto);
    }
}