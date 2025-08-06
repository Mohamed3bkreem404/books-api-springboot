package com.SpringData.DataProject.Controller;

import com.SpringData.DataProject.Model.AccountModel;
import com.SpringData.DataProject.Service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountsService accountsService;

    @PostMapping("/register")
    public AccountModel register(@RequestBody AccountModel accountModel){
        return accountsService.register(accountModel);
    }
}
