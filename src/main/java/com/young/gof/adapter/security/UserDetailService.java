package com.young.gof.adapter.security;

public interface UserDetailService {

    UserDetails loadUser(String username);
}
