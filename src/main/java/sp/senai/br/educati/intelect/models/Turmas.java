package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import lombok.*;

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


    @ManyToMany
    @JoinTable(
            name="pessoas_turmas",
            joinColumns = @JoinColumn(name="turma_id"),
            inverseJoinColumns = @JoinColumn(name="pessoa_id")
    )
    private List<Pessoa> alunos = new ArrayList<Pessoa>();

    //get and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pessoa> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Pessoa> alunos) {
        this.alunos = alunos;
    }
}
