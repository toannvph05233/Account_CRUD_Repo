package codegym.service;

import codegym.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IAccountService {
    Account save(Account account);

    Account findById(long id);

    ArrayList<Account> findAll();

    ArrayList<Account> findAllByName(String name);

    void Delete(Account account);

    void edit(Account account);
}
