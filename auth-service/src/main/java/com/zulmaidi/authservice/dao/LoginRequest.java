package com.zulmaidi.authservice.dao;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
