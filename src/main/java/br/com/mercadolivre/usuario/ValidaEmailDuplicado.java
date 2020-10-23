package br.com.mercadolivre.usuario;

import br.com.mercadolivre.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidaEmailDuplicado implements Validator {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        UsuarioRequest usuarioRequest = (UsuarioRequest) target;

        if (usuarioRepository.findByLogin(usuarioRequest.getLogin()).isPresent()) {
            errors.rejectValue("login", null, "Login já possui cadastro no sistema, tente com outro!");
        }
    }
}
