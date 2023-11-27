package sp.senai.br.educati.intelect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senai.br.educati.intelect.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
