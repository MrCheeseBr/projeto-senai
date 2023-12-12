package sp.senai.br.educati.intelect.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sp.senai.br.educati.intelect.models.Professor;
import sp.senai.br.educati.intelect.repository.ProfessorRepository;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ApiProfController {

    @Autowired
    private ProfessorRepository professorRepository;

    //CRUD - Create, Read, Update, DELETE

    //Create
    @PostMapping
    public void inserir(@RequestBody Professor professor){
        professorRepository.save(professor);
    }
    //REad
    @GetMapping
    public List<Professor> buscarProfessores(){
        return professorRepository.findAll();
    }
    //Update
    @PutMapping
    public void alterar(@RequestBody Professor professor){
        professorRepository.save(professor);
    }
    //delete
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        professorRepository.deleteById(id);
    }




}
