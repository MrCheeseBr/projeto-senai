package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sp.senai.br.educati.intelect.enums.Perfil;

import java.util.ArrayList;


@Data
@Entity
@DiscriminatorValue("P")
public class Professor extends Pessoa{

    public Professor(){
        this.setPerfil(Perfil.PROFESSOR);
    }

    @NotNull(message = "Informe a renumeração")
    private Long renumeracao;

    @ManyToMany(mappedBy = "pessoas")
    private ArrayList<Turmas> turmas = new ArrayList<Turmas>();

    //get and setters


    public Long getRenumeracao() {
        return renumeracao;
    }

    public void setRenumeracao(Long renumeracao) {
        this.renumeracao = renumeracao;
    }

    public ArrayList<Turmas> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turmas> turmas) {
        this.turmas = turmas;
    }
}
