package sp.senai.br.educati.intelect.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import sp.senai.br.educati.intelect.enums.Perfil;



@Entity
@DiscriminatorValue("A")
public class Aluno extends Pessoa {

    public Aluno() {
        this.setPerfil(Perfil.ALUNO);
    }



    @NotEmpty(message = "Informe a matrícula")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricula;

    //get and setters

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
