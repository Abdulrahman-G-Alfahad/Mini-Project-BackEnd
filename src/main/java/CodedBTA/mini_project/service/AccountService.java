package CodedBTA.mini_project.service;

import CodedBTA.mini_project.entity.AccountEntity;
import CodedBTA.mini_project.entity.UserEntity;

public interface AccountService {
    AccountEntity createAccount(UserEntity user, Double initialBalance);
    AccountEntity getAccount(UserEntity user);
    AccountEntity updateBalance(UserEntity user, Double newBalance);
}
