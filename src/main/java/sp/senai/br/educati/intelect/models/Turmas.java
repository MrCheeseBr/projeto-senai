package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turmas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe o nome da turma")
    private String nome;

    @NotEmpty(message = "Informe um período")
    private String periodoTurmas;

    private String descricao;

    @NotEmpty(message = "Informe a data de início")
    private String dataInicio;

    @NotEmpty(message = "Informe a data de conclusão")
    private String dataConclusao;

    private String curso;

    @ManyToMany
    @JoinTable(
            name="pessoas_turmas",
            joinColumns = @JoinColumn(name="turma_id"),
            inverseJoinColumns = @JoinColumn(name="pessoa_id")
    )
    private List<Pessoa> pessoas;


    //get and setters

    public void setId(Long id) {
        this.id = id;
    }


    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeriodoTurmas(String periodoTurmas) {
        this.periodoTurmas = periodoTurmas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPeriodoTurmas() {
        return periodoTurmas;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public String getCurso() {
        return curso;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
