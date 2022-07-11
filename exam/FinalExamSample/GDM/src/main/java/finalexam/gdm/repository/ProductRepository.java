package finalexam.gdm.repository;

import finalexam.gdm.model.Product;
import finalexam.gdm.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query(value = "SELECT * FROM products t WHERE t.name LIKE %?1%", nativeQuery = true)
    List<Supplier> findByProductName(String name);
}
