package finalexam.gdm.repository;

import finalexam.gdm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customers t ORDER BY t.first_name ASC", nativeQuery = true)
    List<Customer> getCustomersByAscName();
    @Query(value = "SELECT * FROM customers t WHERE t.first_name LIKE %?1%", nativeQuery = true)
    List<Customer> findByCustomerName(String name);
}
