package com.ks.accountapp;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {

        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") ObjectId id) {

        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyAccountById(@PathVariable("id") ObjectId id, @Valid @RequestBody Account accounts) {
        accounts.set_id(id);
        repository.save(accounts);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Account createAccount(@Valid @RequestBody Account accounts) {
        accounts.set_id(ObjectId.get());
        repository.save(accounts);
        return accounts;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}