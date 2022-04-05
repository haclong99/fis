package vn.fis.finaltestaphuoc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaphuoc.entity.TrackEntry;

@Repository
public interface TrackEntryRepository extends CrudRepository<TrackEntry, Long> {
}
