package sp.senai.br.educati.intelect.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sp.senai.br.educati.intelect.models.Aluno;
import sp.senai.br.educati.intelect.repository.AlunoRepository;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class ApiAlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    //CRUD - Create, Read, Update, DELETE

    //Create
    @PostMapping
    public void inserir(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
    }
    //REad
    @GetMapping
    public List<Aluno> buscarAlunos(){
        return alunoRepository.findAll();
    }
    //Update
    @PutMapping
    public void alterar(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
    }
    //delete
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }




}
