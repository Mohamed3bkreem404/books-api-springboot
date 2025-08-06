package com.SpringData.DataProject.Service;

import com.SpringData.DataProject.Model.AccountModel;
import com.SpringData.DataProject.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private  AccountRepo accountRepo;


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public AccountModel register(AccountModel accountModel) {
        accountModel.setPassword(bCryptPasswordEncoder.encode(accountModel.getPassword()));
        return accountRepo.save(accountModel);
    }
}

