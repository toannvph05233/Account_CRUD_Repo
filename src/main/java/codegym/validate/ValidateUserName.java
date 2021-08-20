package codegym.validate;

import codegym.model.Account;
import codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;

public class ValidateUserName implements Validator {
    @Autowired
    IAccountService iAccountService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ArrayList<Account> list = iAccountService.findAll();
        Account account = (Account) target;

        for (Account a:list) {
            if (a.getUserName().equals(account.getUserName())){
                errors.rejectValue("userName", "userName.duplicate");
                break;
            }
        }
    }
}
