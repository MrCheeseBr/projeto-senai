package sp.senai.br.educati.intelect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senai.br.educati.intelect.models.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    Atividade findByTitulo (String titulo);
}
