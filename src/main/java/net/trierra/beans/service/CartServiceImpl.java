package net.trierra.beans.service;

import net.trierra.beans.dao.CartDao;
import net.trierra.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * User: trierra
 * Date: 9/5/14
 */
@Component
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private Cart cart;

    @Autowired
    CartDao cartDao;

    @Override
    public Cart addProduct(String product, Long cartId) {
        if (null != cartId) {
            cart = getCartById(cartId);
        } else {
            cart = new Cart(2L);
        }
        cart.getProductList().add(product);
        return cart;
    }

    @Override
    public Cart removeProduct(String name, Long cartId) {
        cart = getCartById(cartId);
        cart.getProductList().remove(name);
        return cart;
    }

    @Override
    public Long saveCart(Cart cart) {
        return cartDao.saveCart(cart);
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    public Cart getCartById(Long cartId) {
        return this.cart;
    }
}
