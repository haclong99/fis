package vn.fis.finaltestaphuoc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaphuoc.entity.Storage;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {
}
