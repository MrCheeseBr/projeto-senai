package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("P")
public class Professor extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe a renumeração")
    private Long renumeraçao;

    @NotEmpty(message = "Informe a turma")
    @ManyToMany(mappedBy = "pessoas")
    private ArrayList<Turmas> turmas = new ArrayList<Turmas>();
}
