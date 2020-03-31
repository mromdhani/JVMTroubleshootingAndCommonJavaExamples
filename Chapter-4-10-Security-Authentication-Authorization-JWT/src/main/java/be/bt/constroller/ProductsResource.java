package be.bt.constroller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bt.domain.Product;
import be.bt.service.ProductsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j    // Thanks to Lombok project !!
public class ProductsResource {

	
    private ProductsService productsService;

    public ProductsResource(ProductsService productsService) {
        this.productsService = productsService;
    }

    
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Set<Product>> allProducts() {
        return new ResponseEntity<>(productsService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Product> productById(@PathVariable String id){
        Product product = productsService.getProductById(id);
        return  (product !=null)?
                new ResponseEntity<>(product, HttpStatus.OK)
                :
                new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        try {
            productsService.updateProduct(product);
            log.info("The product "+ product.getId()+ " has been updated successfully");
            return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
        } catch(Exception ex) {
            log.error("Execption found when updating "+ product.getId()
                    + " Exception message: "+ex.getMessage());
            return new ResponseEntity<>(product, HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
       if(productsService.deleteProduct(id)) {
            log.info("The product "+ id+ " has been deleted successfully");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            log.error("Le id "+ id +"ne correspond pas à un produit existant");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
