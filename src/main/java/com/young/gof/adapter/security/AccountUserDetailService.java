package com.young.gof.adapter.security;

import com.young.gof.adapter.Account;
import com.young.gof.adapter.AccountService;

public class AccountUserDetailService implements UserDetailService{

    AccountService accountService;

    public AccountUserDetailService(AccountService accountService){
        this.accountService = accountService;
    }
    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
