package sp.senai.br.educati.intelect.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sp.senai.br.educati.intelect.models.Administrador;
import sp.senai.br.educati.intelect.repository.AdministradorRepository;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class ApiAdminController {

    @Autowired
    private AdministradorRepository administradorRepository;

    //CRUD - Create, Read, Update, DELETE

    //Create
    @PostMapping
    public void inserir(@RequestBody Administrador administrador){
        administradorRepository.save(administrador);
    }
    //REad
    @GetMapping
    public List<Administrador> buscarAdministradores(){
        return administradorRepository.findAll();
    }
    //Update
    @PutMapping
    public void alterar(@RequestBody Administrador administrador){
        administradorRepository.save(administrador);
    }
    //delete
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        administradorRepository.deleteById(id);
    }




}

