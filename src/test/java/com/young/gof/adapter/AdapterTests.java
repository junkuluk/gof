package com.young.gof.adapter;

import com.young.gof.adapter.security.AccountUserDetailService;
import com.young.gof.adapter.security.LoginHandler;
import com.young.gof.adapter.security.UserDetailService;
import org.junit.jupiter.api.Test;

public class AdapterTests {

    @Test
    void adapter_test(){
        AccountService accountService = new AccountService();
        UserDetailService userDetailService = new AccountUserDetailService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailService);
        loginHandler.login("young","1234");
    }
}
