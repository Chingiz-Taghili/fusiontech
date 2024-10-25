package com.multishop.fusiontech.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private String name;
    private String surname;
    private String email;
    private int gender;
    private String imageUrl;
    private String password;
}