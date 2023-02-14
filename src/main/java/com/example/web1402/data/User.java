package com.example.web1402.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private String login;
    private String password;
}
