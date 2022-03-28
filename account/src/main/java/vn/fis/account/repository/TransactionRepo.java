package vn.fis.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.account.entity.Transaction;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
}
