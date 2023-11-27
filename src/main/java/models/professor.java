package models;

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
public class professor extends pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe a renumeração")
    private Long renumeraçao;

    @NotEmpty(message = "Informe a turma")
    @ManyToMany(mappedBy = "pessoas")
    private ArrayList<turmas> turmas = new ArrayList<turmas>();
}
