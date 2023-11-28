package sp.senai.br.educati.intelect.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sp.senai.br.educati.intelect.enums.Perfil;
import sp.senai.br.educati.intelect.models.*;
import sp.senai.br.educati.intelect.repository.AdministradorRepository;
import sp.senai.br.educati.intelect.repository.AlunoRepository;
import sp.senai.br.educati.intelect.repository.ProfessorRepository;
import sp.senai.br.educati.intelect.repository.TurmasRepository;

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
        return "/administrador/home";
    }

    //cadastros
    @GetMapping("/cadastrarAluno")
    public String cadastrarAluno(Model model){
        model.addAttribute("cadAluno", new Aluno());

        return "/administrador/cadAluno";
    }

    @GetMapping("/cadastrarProfessos")
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
        if(aluno.getTurmas()!= null){
            Turmas turmasBanco = turmasRepository.findById(aluno.getTurmas().get(0).getId()).orElseThrow(()
                -> new IllegalArgumentException("ID Inválido")
            );

            //adiciona turma na lista de turma do aluno
            //aluno.addTurma(turmasBanco);

            //adiciona turma ao aluno
            //turmasBanco.addPessoa(aluno);

        }
        alunoRepository.save(aluno);
        attributes.addFlashAttribute("mensagemAlunoSalvo", "Aluno salvo com sucesso");
        return "redirect:/administrador/cadAluno";
    }

    @PostMapping("/salvarProfessor")
    public String salvarProfessor(@Valid Professor professor, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadProfessor";
        }
        //verifica se turmas foram selecionadas
        if(professor.getTurmas()!= null){
            Turmas turmasBanco = turmasRepository.findById(professor.getTurmas().get(0).getId()).orElseThrow(()
                    -> new IllegalArgumentException("ID Inválido")
            );

            //adiciona turma na lista de turma do professor
            //professor.addTurma(turmasBanco);

            //adiciona turma ao professor
            //turmasBanco.addPessoa(professor);

        }
        professorRepository.save(professor);
        attributes.addFlashAttribute("mensagemProfessorSalvo", "Professor salvo com sucesso");
        return "redirect:/administrador/cadProfessor";
    }

    @PostMapping("/salvarAdministrador")
    public String salvarAdministrador(@Valid Administrador administrador, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadAdmin";
        }

        administradorRepository.save(administrador);
        attributes.addFlashAttribute("mensagemAdminSalvo", "Administrador salvo com sucesso");
        return "redirect:/administrador/cadAdmin";
    }

    @PostMapping("/salvarTurmas")
    public String salvarTurmas(@Valid Turmas turmas, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/administrador/cadTurmas";
        }

        turmasRepository.save(turmas);
        attributes.addFlashAttribute("mensagemTurmaSalva", "Turma salva com sucesso");
        return "redirect:/administrador/cadTurmas";
    }

    //alteração





}
