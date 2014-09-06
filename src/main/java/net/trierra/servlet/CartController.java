package net.trierra.servlet;

import net.trierra.beans.service.CartService;
import net.trierra.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;

/**
 * User: trierra
 * Date: 9/5/14
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart/add")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    protected void addToCart(@RequestParam("name") String name, HttpSession sessionObj) {
        Long cartId = (Long) sessionObj.getAttribute("cartId");
        cartId = addProductToCart(name, cartId);
        sessionObj.setAttribute("cartId", cartId);
    }

    @RequestMapping(value = "/cart/get")
    protected Cart getCart(HttpSession sessionObj) {
        Long cartId = (Long) sessionObj.getAttribute("cartId");
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/cart/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    protected void removeFromCart(@RequestParam("name") String name, HttpSession sessionObj) {
        Long cartId = (Long) sessionObj.getAttribute("cartId");
        removeProductFromCart(name, cartId);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    private Long addProductToCart(String name, Long cartId) {
        Cart cart = cartService.addProduct(name, cartId);
        return cartService.saveCart(cart);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    private Long removeProductFromCart(String name, Long cartId) {
        Cart cart = cartService.removeProduct(name, cartId);
        return cartService.saveCart(cart);
    }
}


