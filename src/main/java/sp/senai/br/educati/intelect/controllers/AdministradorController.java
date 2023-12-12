package sp.senai.br.educati.intelect.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sp.senai.br.educati.intelect.models.*;
import sp.senai.br.educati.intelect.repository.AdministradorRepository;
import sp.senai.br.educati.intelect.repository.AlunoRepository;
import sp.senai.br.educati.intelect.repository.ProfessorRepository;
import sp.senai.br.educati.intelect.repository.TurmasRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmasRepository turmasRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping
    public String homeAdm(){
        return "/administrador/homeAdm";
    }

    //cadastros
    @GetMapping("/cadastrarAluno")
    public String cadastrarAluno(Model model){

        model.addAttribute("cadAluno", new Aluno());


        return "/administrador/cadAluno";
    }

    @GetMapping("/cadastrarProfessores")
    public String cadastrarProfessor(Model model){
        model.addAttribute("cadProfessor", new Professor());

        return "/administrador/cadProfessor";
    }

    @GetMapping("/cadastrarAdmin")
    public String cadastrarAdmin(Model model){
        model.addAttribute("cadAdmin", new Administrador());

        return "/administrador/cadAdmin";
    }

    @GetMapping("/cadastrarTurmas")
    public String cadastrarTurmas(Model model){
        model.addAttribute("cadTurmas", new Turmas());

        return "/administrador/cadTurmas";
    }

    //salvar os cadastros


    @PostMapping("/salvarAluno")
    public String salvarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadAluno";
        }
        //verifica se turmas foram selecionadas
        /*if(aluno.getTurmas()!= null){
            Turmas turmasBanco = turmasRepository.findById(aluno.getTurmas().get(0).getId()).orElseThrow(()
                    -> new IllegalArgumentException("ID Inválido")
            );

            //adiciona turma na lista de turma do aluno
            aluno.addTurma(turmasBanco);

            //adiciona turma ao aluno
            turmasBanco.addPessoa(aluno);

        }*/


        alunoRepository.save(aluno);
        attributes.addFlashAttribute("mensagemAlunoSalvo", "Aluno salvo com sucesso");
        return "redirect:/administrador/cadastrarAluno";
    }


    @PostMapping("/salvarProfessor")
    public String salvarProfessor(@Valid Professor professor, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadProfessor";
        }
        /*verifica se turmas foram selecionadas
        if(professor.getTurmas()!= null){
            Turmas turmasBanco = turmasRepository.findById(professor.getTurmas().get(0).getId()).orElseThrow(()
                    -> new IllegalArgumentException("ID Inválido")
            );

            //adiciona turma na lista de turma do professor
            professor.addTurma(turmasBanco);

            //adiciona turma ao professor
            turmasBanco.addPessoa(professor);

        }*/
        professorRepository.save(professor);
        attributes.addFlashAttribute("mensagemProfessorSalvo", "Professor salvo com sucesso");
        return "redirect:/administrador/cadastrarProfessores";
    }

    @PostMapping("/salvarAdministrador")
    public String salvarAdministrador(@Valid Administrador administrador, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadAdmin";
        }

        administradorRepository.save(administrador);
        attributes.addFlashAttribute("mensagemAdminSalvo", "Administrador salvo com sucesso");
        return "redirect:/administrador/cadastrarAdmin";
    }

    @PostMapping("/salvarTurmas")
    public String salvarTurmas(@Valid Turmas turmas, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadTurmas";
        }

        turmasRepository.save(turmas);
        attributes.addFlashAttribute("mensagemTurmaSalva", "Turma salva com sucesso");
        return "redirect:/administrador/cadastrarTurmas";
    }

    //listas/listagens

    @GetMapping("/listaAlunos")
    public String listagemAlunos(Model model){
        List<Aluno> listaAlunos= alunoRepository.findAll();

        model.addAttribute("ListaAlunos", listaAlunos);

        return "/administrador/listaAlunos";
    }

    @GetMapping("/listaProfessores")
    public String listagemProfessores(Model model){
        List<Professor> listaProfessor= professorRepository.findAll();

        model.addAttribute("listaProfessores", listaProfessor);

        return "/administrador/listaProfessores";
    }

    @GetMapping("/listaAdministrador")
    public String listagemAdmin(Model model){
        List<Administrador> listaAdmin= administradorRepository.findAll();

        model.addAttribute("listaAdmin", listaAdmin);

        return "/administrador/listaAdmin";
    }

    @GetMapping("/listaTurmas")
    public String listagemTurmas(Model model){
        List<Turmas> listaTurmas= turmasRepository.findAll();

        model.addAttribute("listaTurmas", listaTurmas);

        return "/administrador/listaTurmas";
    }

    //deletes
    @GetMapping("/excluirAluno/{id}")
    public String excluirAlunos(@PathVariable("id") Long id,RedirectAttributes attributes){
        Aluno aluno= alunoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido!"));

        alunoRepository.delete(aluno);

        attributes.addFlashAttribute("mensagemDelAlunos", "Aluno excluído com sucesso!");
        return "redirect:/administrador/listaAlunos";
    }

    @GetMapping("/excluirProfessor/{id}")
    public String excluirProfessores(@PathVariable("id") Long id,RedirectAttributes attributes){
        Professor professor= professorRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido!"));

        professorRepository.delete(professor);

        attributes.addFlashAttribute("mensagemDelProfessores", "Professor excluído com sucesso!");
        return "redirect:/administrador/listaProfessores";
    }

    @GetMapping("/excluirAdministrador/{id}")
    public String excluirAdministradores(@PathVariable("id") Long id,RedirectAttributes attributes){
        Administrador administrador= administradorRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido!"));

        administradorRepository.delete(administrador);

        attributes.addFlashAttribute("mensagemDelAdmin", "Administrador excluído com sucesso!");
        return "redirect:/administrador/listaAdministrador";
    }

    @GetMapping("/excluirTurma/{id}")
    public String excluirTurmas(@PathVariable("id") Long id,RedirectAttributes attributes){
        Turmas turmas= turmasRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido!"));

        turmasRepository.delete(turmas);

        attributes.addFlashAttribute("mensagemDelTurmas", "Turmas excluída com sucesso!");
        return "redirect:/administrador/excluirTurmas";
    }


    //alteração

    @GetMapping("/alterarAluno/{id}")
    public String alterarAluno(@PathVariable("id") Long id, Model model){

        Aluno aluno= alunoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        model.addAttribute("alunoAtualizado", aluno);

        return "/administrador/alterarAluno";
    }

    @PostMapping("/alterarAluno/{id}")
    public  String alterarAluno(@PathVariable("id") Long id, @Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()) {
            return "/administrador/alterarAluno";
        }

        Aluno alunoAtualizado= alunoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        alunoAtualizado.setMatricula(aluno.getMatricula());
        alunoAtualizado.setNome(aluno.getNome());
        alunoAtualizado.setId(aluno.getId());
        alunoAtualizado.setTurmas(aluno.getTurmas());
        alunoAtualizado.setTelefone(aluno.getTelefone());
        alunoAtualizado.setCpf(aluno.getCpf());
        alunoAtualizado.setData_nascimento(aluno.getData_nascimento());
        alunoAtualizado.setEmail(aluno.getEmail());
        alunoAtualizado.setEndereco(aluno.getEndereco());
        alunoAtualizado.setRg(aluno.getRg());
        alunoAtualizado.setSenha(aluno.getSenha());

        alunoRepository.save(alunoAtualizado);

        attributes.addFlashAttribute("mensagemAlterarAluno", "Aluno atualizado com sucesso!");

        return "redirect:/administrador/listaAlunos";
    }

    @GetMapping("/alterarAdmin/{id}")
    public String alterarAdmin(@PathVariable("id") Long id, Model model){

        Administrador administrador= administradorRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        model.addAttribute("adminAtualizado", administrador);

        return "/administrador/alterarAdmin";
    }

    @PostMapping("/alterarAdmin/{id}")
    public  String alterarAdmin(@PathVariable("id") Long id, @Valid Administrador administrador, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()) {
            return "/administrador/alterarAdmin";
        }

        Administrador administradorAtualizado= administradorRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        administradorAtualizado.setNome(administrador.getNome());
        administradorAtualizado.setId(administrador.getId());
        administradorAtualizado.setTurmas(administrador.getTurmas());
        administradorAtualizado.setTelefone(administrador.getTelefone());
        administradorAtualizado.setCpf(administrador.getCpf());
        administradorAtualizado.setData_nascimento(administrador.getData_nascimento());
        administradorAtualizado.setEmail(administrador.getEmail());
        administradorAtualizado.setEndereco(administrador.getEndereco());
        administradorAtualizado.setRg(administrador.getRg());
        administradorAtualizado.setSenha(administrador.getSenha());
        administradorAtualizado.setRenumeracao(administrador.getRenumeracao());

        administradorRepository.save(administradorAtualizado);

        attributes.addFlashAttribute("mensagemAlterarAdmin", "Administrador atualizado com sucesso!");

        return "redirect:/administrador/listaAdministrador";
    }

    @GetMapping("/alterarProfessor/{id}")
    public String alterarProfessor(@PathVariable("id") Long id, Model model){

        Professor professor= professorRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        model.addAttribute("profAtualizado", professor);

        return "/administrador/alterarProfessor";
    }

    @PostMapping("/alterarProfessor/{id}")
    public  String alterarProfessor(@PathVariable("id") Long id, @Valid Professor professor, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()) {
            return "/administrador/alterarProfessor";
        }

        Professor professorAtualizado= professorRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        professorAtualizado.setNome(professor.getNome());
        professorAtualizado.setId(professor.getId());
        professorAtualizado.setTurmas(professor.getTurmas());
        professorAtualizado.setTelefone(professor.getTelefone());
        professorAtualizado.setCpf(professor.getCpf());
        professorAtualizado.setData_nascimento(professor.getData_nascimento());
        professorAtualizado.setEmail(professor.getEmail());
        professorAtualizado.setEndereco(professor.getEndereco());
        professorAtualizado.setRg(professor.getRg());
        professorAtualizado.setSenha(professor.getSenha());
        professorAtualizado.setRenumeracao(professor.getRenumeracao());

        professorRepository.save(professorAtualizado);

        attributes.addFlashAttribute("mensagemAlterarProfessor", "Professor atualizado com sucesso!");

        return "redirect:/administrador/listaProfessores";
    }

    @GetMapping("/alterarTurmas/{id}")
    public String alterarTurmas(@PathVariable("id") Long id, Model model){

        Turmas turmas= turmasRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        model.addAttribute("alterarTurmas", turmas);

        return "/administrador/alterarTurmas";
    }
    @PostMapping("/alterarTurmas/{id}")
    public  String alterarTurmas(@PathVariable("id") Long id, @Valid Turmas turmas, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()) {
            return "/administrador/alterarTurmas";
        }

        Turmas turmasAtualizadas= turmasRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido"));

        turmasAtualizadas.setPessoas(turmas.getPessoas());
        turmasAtualizadas.setId(turmas.getId());
        turmasAtualizadas.setPeriodoTurmas(turmas.getPeriodoTurmas());
        turmasAtualizadas.setDescricao(turmas.getDescricao());
        turmasAtualizadas.setDataConclusao(turmas.getDataConclusao());
        turmasAtualizadas.setDataInicio(turmas.getDataInicio());
        turmasAtualizadas.setCurso(turmasAtualizadas.getCurso());
        turmasAtualizadas.setNome(turmas.getNome());

        turmasRepository.save(turmasAtualizadas);

        attributes.addFlashAttribute("mensagemAlterarTurmas", "Turma atualizada com sucesso!");

        return "redirect:/administrador/alterarTurmas";
    }



}
