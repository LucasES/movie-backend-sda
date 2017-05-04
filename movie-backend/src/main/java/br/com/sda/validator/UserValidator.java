package br.com.sda.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.sda.model.User;
import br.com.sda.service.impl.UserServiceImpl;

/**
 * Classe de validação dos campos da classe User.
 * 
 * @author Lucas Araújo
 *
 */
@Component
public class UserValidator implements Validator{

	@Autowired
    private UserServiceImpl userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "O username deve ter entre 4 a 32 caracteres");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Login já existe!");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 16) {
            errors.rejectValue("password", "A senha deve ter entre 4 a 16 caracteres!");
        }
    }
}
