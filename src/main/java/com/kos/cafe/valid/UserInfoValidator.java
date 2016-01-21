package com.kos.cafe.valid;


import com.kos.cafe.domain.User;

public class UserInfoValidator {

    static String resultMessage = "";

    public static String  valid(User user){
        StringBuilder builder = new StringBuilder();
        builder.append("");
        if (user.getLogin().length()<4){builder.append("Логин должен быть не короче 4 символов,");}
        if (user.getPassword().length()<6){builder.append("пароль должен быть не короче 6 символов,");}
        if (!EmailValidator.isValid(user.getEmail())){builder.append("неправильный формат E-mail адреса,");}
        if (user.getName().length()<2){builder.append("имя должно быть не короче двух символов,");}
        if (user.getSurname().length()<2){builder.append("фамилия должна быть не короче двух символов");}
        return builder.toString();
    }
}
