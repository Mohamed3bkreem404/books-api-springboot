package com.SpringData.DataProject.Repository;

import com.SpringData.DataProject.Model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountModel , Integer> {

    Optional <AccountModel> findByUsername(String username);
}
