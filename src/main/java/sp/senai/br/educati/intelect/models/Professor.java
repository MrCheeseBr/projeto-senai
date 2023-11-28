package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sp.senai.br.educati.intelect.enums.Perfil;

import java.util.ArrayList;


@Data
@Entity
@DiscriminatorValue("P")
public class Professor extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Professor(){
        this.setPerfil(Perfil.PROFESSOR);
    }

    @NotEmpty(message = "Informe a renumeração")
    private Long renumeracao;

    @NotEmpty(message = "Informe a turma")
    @ManyToMany(mappedBy = "pessoas")
    private ArrayList<Turmas> turmas = new ArrayList<Turmas>();

    //get and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
