package com.zulmaidi.authservice.security.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {
    UserDetails loadUserByUsername(String usename) throws UsernameNotFoundException;
}
