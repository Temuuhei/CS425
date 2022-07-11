package finalexam.gdm.service;

import finalexam.gdm.model.Product;

import java.util.List;

public interface ProductService {

    Product addNewProduct(Product product);

    List<Product> getAllProducts();
}
