package sp.senai.br.educati.intelect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senai.br.educati.intelect.models.Administrador;

public interface AdministradorRepository extends JpaRepository <Administrador, Long> {
}
