package be.bt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import be.bt.domain.Product;
import be.bt.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository repository;


    public ProductsServiceImpl(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Set<Product> getAllProducts() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Product getProductById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public boolean deleteProduct(String id) {
        Product product = getProductById(id);
        boolean retour = false;
        if (product != null) {
            repository.delete(product);
            retour = true;
        }
        return retour;
    }
}
