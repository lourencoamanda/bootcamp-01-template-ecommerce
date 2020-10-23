package br.com.mercadolivre.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Usuario  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "{ Login Inválido }")
    @NotNull(message = "{ Login não pode ser null }")
    @Email(message = "{ Login precisa ser em formato de email}")
    private String login;

    @NotBlank (message = "{ Password Inválido }")
    @NotNull (message = "{ Password não pode ser null }")
    @Size(min = 6, message = "{ Password deve ter no minimo 6 caracteres }")
    private String password;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Deprecated
    public Usuario(){
    }

    public Usuario(@NotBlank(message = "{ Login Inválido }") @NotNull(message = "{ Login não pode ser null }") @Email(message = "{ Login precisa ser em formato de email}") String login, @NotBlank(message = "{ Password Inválido }") @NotNull(message = "{ Password não pode ser null }") @Size(min = 6, message = "{ Password deve ter no minimo 6 caracteres }") String password) {
        this.login = login;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
