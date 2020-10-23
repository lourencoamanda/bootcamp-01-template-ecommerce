package br.com.mercadolivre.usuario;

import br.com.mercadolivre.entities.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank (message = "{ Login Inválido }")
    @NotNull (message = "{ Login não pode ser null }")
    @Email (message = "{ Login precisa ser em formato de email}")
    private  String login;

    @NotBlank (message = "{ Password Inválido }")
    @NotNull (message = "{ Password não pode ser null }")
    @Size(min = 6, message = "{ Password deve ter no minimo 6 caracteres }")
    private String password;

    public UsuarioRequest(){
    }

    public UsuarioRequest(@NotBlank(message = "{ Login Inválido }") @NotNull(message = "{ Login não pode ser null }") @Email(message = "{ Login precisa ser em formato de email}") String login, @NotBlank(message = "{ Password Inválido }") @NotNull(message = "{ Password não pode ser null }") @Size(min = 6, message = "{ Password deve ter no minimo 6 caracteres }") String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario toModel(){
        return new Usuario(login,password);
    }
}
