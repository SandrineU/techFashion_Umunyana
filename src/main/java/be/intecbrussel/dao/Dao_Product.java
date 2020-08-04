package be.intecbrussel.dao;

public interface Dao_Product {

    List<Producto> getProductList();

    Producto getProductById(int producto_id);

    void addProduct(Producto producto);

    void editProduct(Producto producto);

    void deleteProduct(Producto producto);
}
