package vn.fis.finaltestaphuoc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaphuoc.entity.Evidence;

import java.util.Optional;

@Repository
public interface EvidenceRepository extends CrudRepository<Evidence, Long> {
    Optional<Evidence> findById(Long id);
}
