package com.example.form.Form;

import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {
    private static final String VALID_CHARACTER = "0123456789_abcdefghijklmnopgrstuvwxyzABCDEFGHIJKLMNOPGRSTUVWXYZ";



    public static void check (String s, boolean loginOrPassword){
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTER.contains(String.valueOf(s.charAt(i)))){
                if (loginOrPassword==true){
                   throw new WrongLoginException("Логин должен содержать только латинские символы цифры или _");

                } else {
                    throw new WrongPasswordException("Пароль должен содержать только латинские символы цифры или _");
                }
            }
        }
    }
}


