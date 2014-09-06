package net.trierra.beans.service;

import net.trierra.model.Cart;

/**
 * User: trierra
 * Date: 9/4/14
 */
public interface CartService {

    public Cart addProduct(String product, Long cartId);

    public Long saveCart(Cart cart);

    public Cart getCart();

    Cart getCartById(Long cartId);

    Cart removeProduct(String name, Long cartId);
}
