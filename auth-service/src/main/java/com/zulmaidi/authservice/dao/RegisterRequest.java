package com.zulmaidi.authservice.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    List<String> roles;
}
