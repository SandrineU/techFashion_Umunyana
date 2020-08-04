package be.intecbrussel.services;

public class ProductService {

    List<Producto> getProductList();

    Producto getProductById(int id);

    void addProduct(Producto producto);

    void editProduct(Producto producto);

    void deleteProduct(Producto producto);

}
