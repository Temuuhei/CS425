package finalexam.gdm.repository;

import finalexam.gdm.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository  extends JpaRepository<Supplier, Long> {
    @Query(value = "SELECT * FROM suppliers t ORDER BY t.name ASC", nativeQuery = true)
    List<Supplier> getSuppliersByAscName();
    @Query(value = "SELECT * FROM suppliers t WHERE t.name LIKE %?1%", nativeQuery = true)
    List<Supplier> findBySupplierName(String name);
}
