package models;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class turmas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToMany
    @JoinTable(
            name="pessoas_turmas",
            joinColumns = @JoinColumn(name="turma_id"),
            inverseJoinColumns = @JoinColumn(name="pessoa_id")
    )
    private List<pessoa> alunos = new ArrayList<pessoa>();
}
