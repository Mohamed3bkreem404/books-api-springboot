package com.SpringData.DataProject.Service;

import com.SpringData.DataProject.Model.AccountDetails;
import com.SpringData.DataProject.Model.AccountModel;
import com.SpringData.DataProject.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel user = accountRepo.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username not found" + username));
        return new AccountDetails(user);
    }
}
