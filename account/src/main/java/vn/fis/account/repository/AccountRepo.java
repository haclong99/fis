package vn.fis.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.account.entity.Account;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
    public Account findByAccountId(Long accountId);
    public List<Account> findAll();
}
