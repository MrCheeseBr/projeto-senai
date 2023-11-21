package models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("A")
public class aluno extends pessoa{
    @NotEmpty(message = "Informe a matrícula")
    private Long matricula;

    @NotEmpty(message = "Informe a turma")
    private List<Turmas> getTurmas(){
        return turmas;
    }

    //get and setters

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
