package CodedBTA.mini_project.service;

import CodedBTA.mini_project.entity.AccountEntity;
import CodedBTA.mini_project.entity.TransactionEntity;
import CodedBTA.mini_project.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

//    @Override
//    public List<TransactionEntity> getAllTransactions(AccountEntity account) {
//        return transactionRepository.findByAccountId();
//    }
//
//    @Override
//    public List<TransactionEntity> getTransactionsByDate(Date date) {
//        return transactionRepository.findByTransactionDate(date);
//    }
}
