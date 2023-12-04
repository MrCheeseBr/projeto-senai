package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import sp.senai.br.educati.intelect.enums.Cursos;
import sp.senai.br.educati.intelect.enums.PeriodoTurmas;

import java.util.ArrayList;
import java.util.List;

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
    private List<Pessoa> pessoas;

    //get and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void addPessoa(Pessoa pessoa){
        pessoa.getTurmas().add(this);
        this.pessoas.add(pessoa);
    }

    public void removePessoa(Pessoa pessoa){
        pessoa.getTurmas().remove(this);
        this.pessoas.remove(pessoa);
    }

}
