package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sp.senai.br.educati.intelect.enums.Perfil;



@Data
@Entity
@DiscriminatorValue("M")
public class Administrador extends Pessoa {

    @NotNull(message = "Informe a renumeração")
    private Long renumeracao;

    public Administrador(){
        this.setPerfil(Perfil.ADMINISTRADOR);
    }


    //get and setters

    public Long getRenumeracao() {
        return renumeracao;
    }

    public void setRenumeracao(Long renumeracao) {
        this.renumeracao = renumeracao;
    }
}
