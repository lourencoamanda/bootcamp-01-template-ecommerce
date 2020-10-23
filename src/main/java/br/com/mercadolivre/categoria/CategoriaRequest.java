package br.com.mercadolivre.categoria;

import br.com.mercadolivre.entities.Categoria;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CategoriaRequest {

    @NotBlank(message = "Categoria inválida")
    private String nome;

    @Positive
    private Long idCategoriaMae;

    @Deprecated
    public CategoriaRequest(){

    }

    public CategoriaRequest(@NotBlank(message = "Categoria inválida") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdCategoriaMae() {
        return idCategoriaMae;
    }

    public void setIdCategoriaMae(Long idCategoriaMae) {
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel(EntityManager manager){
        Categoria categoria = new Categoria(nome);

        if (idCategoriaMae != null){
            Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
            Assert.notNull(categoriaMae, "O id da categoria mãe não existe!");
            categoria.setCategoriaMae(categoriaMae);
        }

        return categoria;
    }
}
