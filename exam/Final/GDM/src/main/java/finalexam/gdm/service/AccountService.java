package finalexam.gdm.service;

import finalexam.gdm.model.Account;

import java.util.List;

public interface AccountService {

    Account addNewAccount(Account account);

    List<Account> getAllAccounts();

    List<Account> getPrimeAccounts();
}
