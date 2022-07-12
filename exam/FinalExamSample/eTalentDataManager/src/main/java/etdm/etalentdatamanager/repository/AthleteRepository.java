package etdm.etalentdatamanager.repository;

import etdm.etalentdatamanager.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>{

    @Query(value = "SELECT * FROM athletes t WHERE t.total_number_of_medals_won > 3 and TIMESTAMPDIFF(year,t.date_of_registration, now()) > 5 ORDER BY t.full_name ASC", nativeQuery = true)
    List<Athlete> getAllEliteAthletesByFullNameAsc();

    @Query(value = "SELECT * FROM athletes t ORDER BY t.full_name ASC", nativeQuery = true)
    List<Athlete> getAllAthletes();
}
