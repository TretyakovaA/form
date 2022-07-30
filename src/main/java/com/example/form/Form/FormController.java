package com.example.form.Form;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }
@GetMapping(path = "/form")
    public static boolean form(String password, String login, String confirmPassword) {
        try {
            formCheck(password, login, confirmPassword);
            return true;
        }
        catch (WrongLoginException | WrongPasswordException e){
            return false;
        }

    }
    public static void formCheck(String password, String login, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.isEmpty() || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20");
        }
        if (password == null || password.isEmpty() || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        }
        FormService.check(password,false);
        FormService.check(login, true);

    }

}
