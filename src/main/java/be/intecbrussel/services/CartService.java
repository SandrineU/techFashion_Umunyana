package be.intecbrussel.services;

public class CartService {

    Cart getCartById(int cart_id);

    void update(Cart cart);

    Cart validate(int cart_id) throws IOException;

}
