package be.intecbrussel.dao.implementation;

@Repository
@Transactional
public class Dao_ProductImpl implements Dao_producto {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Producto> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Producto");
        List<Producto> lista_productos = query.list();
        session.flush();

        return lista_productos;
    }

    public Producto getProductById(int producto_id) {
        Session session = sessionFactory.getCurrentSession();
        Producto producto = (Producto) session.get(Producto.class, producto_id);
        session.flush();

        return producto;
    }

    public void addProduct(Producto producto) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(producto);
        session.flush();
    }

    public void editProduct(Producto producto) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(producto);
        session.flush();
    }

    public void deleteProduct(Producto producto) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(producto);
        session.flush();
    }
}