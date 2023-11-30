package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import sp.senai.br.educati.intelect.enums.Cursos;
import sp.senai.br.educati.intelect.enums.PeriodoTurmas;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Turmas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe o nome da turma")
    private String nome;

    @NotEmpty(message = "Informe um período")
    private PeriodoTurmas periodoTurmas;

    private String descricao;

    @NotEmpty(message = "Informe a data de início")
    private Integer dataInicio;

    @NotEmpty(message = "Informe a data de conclusão")
    private String dataConclusao;

    @NotEmpty(message = "Informe o curso da turma")
    private Cursos curso;
    @ManyToMany
    @JoinTable(
            name="pessoas_turmas",
            joinColumns = @JoinColumn(name="turma_id"),
            inverseJoinColumns = @JoinColumn(name="pessoa_id")
    )
    private ArrayList<Pessoa> alunos = new ArrayList<Pessoa>();

    //get and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Pessoa> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Pessoa> alunos) {
        this.alunos = alunos;
    }
}
