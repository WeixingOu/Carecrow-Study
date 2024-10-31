package com.std.carecrow.domain.dto.record;

import com.std.carecrow.domain.enumtype.Sex;
import com.std.carecrow.domain.enumtype.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record AddSysUserDTO(
    @NotBlank(message = "Username is required")
    @Size(max = 30, message = "Username must not exceed 30 characters")
    String username,

    @NotBlank(message = "Nickname is required")
    @Size(max = 30, message = "Nickname must not exceed 30 characters")
    String nickname,

    @Email(message = "Email must be a valid email address")
    @Size(max = 50, message = "Email must not exceed 50 characters")
    String email,

    @Size(max = 11, message = "Mobile number must not exceed 11 characters")
    String mobile,

    Sex sex,

    @URL
    @Size(max = 100, message = "Avatar URL must not exceed 100 characters")
    String avatar,

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters long")
    String password,

    Status status,

    @NotBlank(message = "Creator is required")
    @Size(max = 30, message = "Creator's name must not exceed 30 characters")
    String creator,
    @NotBlank(message = "Creator is required")
    @Size(max = 30, message = "Creator's name must not exceed 30 characters")
    String updater,

    String remark
){
}