package com.example.web1402.services;

import com.example.web1402.data.User;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class LoginService {

    @SneakyThrows
    public User checkLogin(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(" ");
                if (s[0].equals(login) && s[1].equals(password)) {
                    return new User(s[2], s[0], s[1]);
                }
            }
            return null;
        }
    }
}
