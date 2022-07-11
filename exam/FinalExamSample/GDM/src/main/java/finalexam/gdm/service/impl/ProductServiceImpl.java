package finalexam.gdm.service.impl;

import finalexam.gdm.model.Product;
import finalexam.gdm.service.ProductService;
import finalexam.gdm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addNewProduct(Product product) {
        var newProduct = productRepository.save(product);
        return newProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        var products = productRepository.findAll();
        return products;
    }

}
