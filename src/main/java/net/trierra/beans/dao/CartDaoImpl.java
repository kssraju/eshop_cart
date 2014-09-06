package net.trierra.beans.dao;

import net.trierra.model.Cart;
import org.springframework.stereotype.Component;

/**
 * User: trierra
 * Date: 9/5/14
 */
@Component
public class CartDaoImpl implements CartDao {

    @Override
    public Long saveCart(Cart cart) {
        if (cart.getId() == null) {
            cart.setId(1L);
            return cart.getId();
        }
        return cart.getId();
    }
}
