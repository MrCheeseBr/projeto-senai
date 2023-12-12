package sp.senai.br.educati.intelect.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sp.senai.br.educati.intelect.models.Turmas;
import sp.senai.br.educati.intelect.repository.TurmasRepository;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class ApiTurmasController {

    @Autowired
    private TurmasRepository turmasRepository;

    //CRUD - Create, Read, Update, DELETE

    //Create
    @PostMapping
    public void inserir(@RequestBody Turmas turmas){
        turmasRepository.save(turmas);
    }
    //REad
    @GetMapping
    public List<Turmas> buscarTurmas(){
        return turmasRepository.findAll();
    }
    //Update
    @PutMapping
    public void alterar(@RequestBody Turmas turmas){
        turmasRepository.save(turmas);
    }
    //delete
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        turmasRepository.deleteById(id);
    }




}
