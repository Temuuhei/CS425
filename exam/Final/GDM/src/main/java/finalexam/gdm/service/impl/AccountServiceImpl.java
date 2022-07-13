package finalexam.gdm.service.impl;

import finalexam.gdm.model.Account;
import finalexam.gdm.service.AccountService;
import finalexam.gdm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account addNewAccount(Account product) {
        var newAccount = accountRepository.save(product);
        return newAccount;
    }

    @Override
    public List<Account> getAllAccounts() {
        var accounts = accountRepository.getAllProductsAscByProductNumber();
        return accounts;
    }

    @Override
    public List<Account> getPrimeAccounts() {
        var accounts = accountRepository.getPrimeAccounts();
        return accounts;
    }

}
