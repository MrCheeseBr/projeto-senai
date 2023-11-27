package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("M")
public class Administrador extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe a renumeração")
    private Long renumeraçao;


    //get and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRenumeraçao() {
        return renumeraçao;
    }

    public void setRenumeraçao(Long renumeraçao) {
        this.renumeraçao = renumeraçao;
    }
}
