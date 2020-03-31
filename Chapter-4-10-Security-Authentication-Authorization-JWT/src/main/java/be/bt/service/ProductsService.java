package be.bt.service;

import java.util.Set;

import be.bt.domain.Product;

public interface ProductsService {

    Product addProduct(Product product);
    Set<Product> getAllProducts();
    Product getProductById(String id);
    Product updateProduct(Product product);
    boolean deleteProduct(String id);
}
