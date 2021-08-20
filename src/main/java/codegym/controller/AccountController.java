package codegym.controller;

import codegym.model.Account;
import codegym.service.IAccountService;
import codegym.validate.ValidateUserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/acc")
public class AccountController {
    @Autowired
    IAccountService iAccountService;

    @Autowired
    ValidateUserName validateUserName;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iAccountService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("account",new Account());
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iAccountService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("account", iAccountService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long id) {
        iAccountService.Delete(iAccountService.findById(id));
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }


    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Account account) {
        iAccountService.edit(account);
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Account account, BindingResult bindingResult) {
        validateUserName.validate(account,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("account",account);
            return modelAndView;
        }
        iAccountService.save(account);
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }
}
