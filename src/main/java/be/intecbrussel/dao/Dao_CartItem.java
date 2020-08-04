package be.intecbrussel.dao;

public interface Dao_CartItem {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int producto_id);
}
