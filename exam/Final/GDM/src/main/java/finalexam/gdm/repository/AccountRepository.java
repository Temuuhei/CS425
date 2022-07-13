package finalexam.gdm.repository;

import finalexam.gdm.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository <Account, Long> {
    @Query(value = "SELECT * FROM accounts t ORDER BY t.account_number ASC", nativeQuery = true)
    List<Account> getAllProductsAscByProductNumber();
    @Query(value = "SELECT * FROM accounts t WHERE t.balance > 10000", nativeQuery = true)
    List<Account> getPrimeAccounts();
}
