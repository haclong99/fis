package vn.fis.finaltestaphuoc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaphuoc.entity.Detective;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetectiveRepository extends CrudRepository<Detective, Long> {
    Optional<Detective> findById(Long id);

    @Query(value = "Select d from detective d where d.person.username = :username and d.ranking = 'SENIOR'", nativeQuery = true)
    List<Detective> findByUsername(String username);
}
