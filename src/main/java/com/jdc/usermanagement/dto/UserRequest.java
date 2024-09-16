package com.jdc.usermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class UserRequest {
    @NotBlank(message = "Username can't be empty")
    private String username;
    @NotBlank(message = "Email can't be empty")
    private String email;
    @PastOrPresent(message = "Join date must be in past or today.")
    private LocalDate joinDate;
}
