package com.zulmaidi.authservice.dao;

import com.zulmaidi.authservice.model.Role;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;
    private List<Role> roles;
}
