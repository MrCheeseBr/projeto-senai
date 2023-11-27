package sp.senai.br.educati.intelect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senai.br.educati.intelect.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
