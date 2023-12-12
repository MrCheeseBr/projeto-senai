package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import lombok.Getter;
import sp.senai.br.educati.intelect.enums.Perfil;

import java.util.ArrayList;


@Entity
@DiscriminatorValue("A")
public class Aluno extends Pessoa {

    public Aluno() {
        this.setPerfil(Perfil.ALUNO);
    }

    @ManyToMany(mappedBy = "pessoas")
    private ArrayList<Turmas> turmas = new ArrayList<Turmas>();


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricula;


    //get and setters

    @Override
    public ArrayList<Turmas> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turmas> turmas) {
        this.turmas = turmas;
    }


    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
