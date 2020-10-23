package br.com.mercadolivre.usuario;

import br.com.mercadolivre.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class UsuariosController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ValidaEmailDuplicado validaEmailDuplicado;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validaEmailDuplicado);
    }

    @PostMapping(path = "save/usuario")
    @Transactional
    public ResponseEntity<?> incluiUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {

        Usuario novoUsuario = usuarioRequest.toModel();
        manager.persist(novoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(novoUsuario);
    }

}
