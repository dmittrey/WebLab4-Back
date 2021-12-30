package com.dmittrey.WebLab4Back.DTO.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthRequest {

    @NotNull(message = "Username should exist")
    @Size(min = 3, max = 30, message = "Username size should be between 3 and 30 symbols")
    @Pattern(regexp = "^[a-zA-Z-0123456789]*$", message = "Username form is incorrect")
    private String username;

    @NotNull(message = "Password should exist")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_])(?=\\S+$).{8,}$",
            message = "Password form is incorrect")
    private String password;
}
