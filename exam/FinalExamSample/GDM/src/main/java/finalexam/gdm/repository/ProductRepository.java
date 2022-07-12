package finalexam.gdm.repository;

import finalexam.gdm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {
    @Query(value = "SELECT * FROM products t ORDER BY t.product_name ASC", nativeQuery = true)
    List<Product> getAllProductsAscByProductNumber();
    @Query(value = "SELECT * FROM products t WHERE t.product_name LIKE %?1%", nativeQuery = true)
    List<Product> findByProductName(String name);
}
