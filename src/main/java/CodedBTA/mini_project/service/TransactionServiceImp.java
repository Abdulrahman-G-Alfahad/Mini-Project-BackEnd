package CodedBTA.mini_project.service;

import CodedBTA.mini_project.entity.AccountEntity;
import CodedBTA.mini_project.entity.TransactionEntity;
import CodedBTA.mini_project.repository.TransactionRepository;

import java.util.Date;
import java.util.List;

public class TransactionServiceImp implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionEntity> getAllTransactions(AccountEntity account) {
        return transactionRepository.getByAccountId(account);
    }

    @Override
    public List<TransactionEntity> getTransactionsByDate(Date date) {
        return transactionRepository.findByTransactionDate(date);
    }
}
