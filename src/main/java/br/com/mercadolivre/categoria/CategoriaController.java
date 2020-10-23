package br.com.mercadolivre.categoria;

import br.com.mercadolivre.entities.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(path = "save/categorias")
    @Transactional
    public ResponseEntity<?> incluiCategoria (@RequestBody @Valid CategoriaRequest categotiaRequest){

        Categoria novaCategoria = categotiaRequest.toModel(manager);
        manager.persist(novaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria incluida com sucesso! ");

    }
}
