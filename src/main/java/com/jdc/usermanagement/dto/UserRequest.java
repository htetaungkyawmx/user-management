package com.jdc.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {
    private String username;
    private String email;
    private LocalDate joinDate;
}
