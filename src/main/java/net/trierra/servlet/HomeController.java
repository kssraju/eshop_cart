package net.trierra.servlet;

import net.trierra.beans.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * User: trierra
 * Date: 9/6/14
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        model.addAttribute("productList", populateProductList());
        return "home";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(ModelMap model) {
        model.addAttribute("productList", cartService.getCart().getProductList());
        return "cart";
    }

    private List<String> populateProductList() {
        List<String> productList = new ArrayList<String>();
        productList.add("Notebook");
        productList.add("Kindle");
        productList.add("Nook");
        productList.add("Motorola");
        productList.add("HTC");
        productList.add("iPhone");
        return productList;
    }
}
