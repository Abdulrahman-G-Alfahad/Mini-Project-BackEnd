package CodedBTA.mini_project.repository;

import CodedBTA.mini_project.entity.AccountEntity;
import CodedBTA.mini_project.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
        List<TransactionEntity> getByAccountId(AccountEntity account);

        List<TransactionEntity> findByTransactionDate(Date transactionDate);
}
