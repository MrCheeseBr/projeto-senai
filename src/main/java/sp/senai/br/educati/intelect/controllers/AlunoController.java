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
import sp.senai.br.educati.intelect.models.Aluno;
import sp.senai.br.educati.intelect.models.Turmas;
import sp.senai.br.educati.intelect.repository.AlunoRepository;
import sp.senai.br.educati.intelect.repository.AtividadeRepository;
import sp.senai.br.educati.intelect.repository.TurmasRepository;

@RequestMapping("/aluno")
@Controller
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmasRepository turmasRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @GetMapping("/cadastrar")
    public String cadastrarAluno(Model model){
        model.addAttribute("cadAluno", new Aluno());

        return "aluno/cadastro";
    }

    @PostMapping("/salvar")
    public String salvarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "aluno/cadastro";
        }

        //verifica se turmas foram selecionadas
        if(aluno.getTurmas() != null){
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
        return  "redirect:/aluno/cadastro";

    }



}
