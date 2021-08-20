package codegym.service;

import codegym.model.Account;
import codegym.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AccountService implements  IAccountService{
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public Account save(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public Account findById(long id) {
        return iAccountRepo.findById(id).get();
    }

    @Override
    public ArrayList<Account> findAll() {
        return (ArrayList<Account>) iAccountRepo.findAll();
    }

    @Override
    public ArrayList<Account> findAllByName(String name) {
        return iAccountRepo.findAllByName2(name);
    }

    @Override
    public void Delete(Account account) {
        iAccountRepo.delete(account);
    }

    @Override
    public void edit(Account account) {
        iAccountRepo.save(account);
    }
}
