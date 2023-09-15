package com.zulmaidi.authservice.controller;

import com.zulmaidi.authservice.dao.LoginRequest;
import com.zulmaidi.authservice.dao.RegisterRequest;
import com.zulmaidi.authservice.dao.UserInfoResponse;
import com.zulmaidi.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @GetMapping("/user")
    public UserInfoResponse user(@AuthenticationPrincipal UserDetails userDetails){
        return authService.user(userDetails);
    }


}
