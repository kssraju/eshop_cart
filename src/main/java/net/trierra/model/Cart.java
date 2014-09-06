package net.trierra.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: trierra
 * Date: 9/4/14
 */
public class Cart {
    private Long id;
    private List<String> productList = new ArrayList<String>();

    public Cart() {
    }

    public Cart(Long cartId) {
        this.id = cartId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }
}
