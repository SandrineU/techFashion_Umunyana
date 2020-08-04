package be.intecbrussel.dao;

public interface Dao_Cart {

    Cart getCartById(int cart_id);

    void update(Cart cart);

    Cart validate(int cart_id) throws IOException;
}
