package vn.fis.finaltestaphuoc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaphuoc.entity.CriminalCase;

import java.util.List;
import java.util.Optional;

@Repository
public interface CriminalCaseRepository extends CrudRepository<CriminalCase, Long> {
    Optional<CriminalCase> findById(Long id);

    @Query(value = "Select c from criminal_case c inner join c.detectiveSet d where d.person.username = :username and d.ranking = 'CHIEF_INSPECTOR'", nativeQuery = true)
    List<CriminalCase> findByUsername(String username);
}
