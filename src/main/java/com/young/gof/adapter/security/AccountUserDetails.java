package com.young.gof.adapter.security;

import com.young.gof.adapter.Account;

public class AccountUserDetails implements UserDetails{

    private final Account account;

    public AccountUserDetails(Account account){
        this.account = account;
    }
    @Override
    public String getUsername() {
        return account.getName()+"/"+account.getEmail();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
