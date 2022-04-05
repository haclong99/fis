package vn.fis.finaltestaphuoc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaphuoc.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
