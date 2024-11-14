package CodedBTA.mini_project.service;

import CodedBTA.mini_project.entity.AccountEntity;
import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.repository.AccountRepository;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public AccountEntity createAccount(UserEntity user, Double initialBalance){
        AccountEntity accountEntity = new AccountEntity(user,initialBalance);
        return accountRepository.save(accountEntity);
    }

    @Override
    public AccountEntity getAccount(UserEntity user) {
        return accountRepository.findByUserId(user.getId()).orElseThrow(() -> new RuntimeException("Account not found for userId " + user.getId()));
    }
    @Override
    public AccountEntity updateBalance(UserEntity user, Double newBalance){
        AccountEntity accountEntity =getAccount(user);
        accountEntity.setBalance(newBalance);
        return accountRepository.save(accountEntity);
    }
}
