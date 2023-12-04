package sp.senai.br.educati.intelect.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sp.senai.br.educati.intelect.models.Aluno;
import sp.senai.br.educati.intelect.models.Atividade;
import sp.senai.br.educati.intelect.models.Turmas;
import sp.senai.br.educati.intelect.repository.AlunoRepository;
import sp.senai.br.educati.intelect.repository.AtividadeRepository;
import sp.senai.br.educati.intelect.repository.TurmasRepository;

import java.util.List;

@RequestMapping("/aluno")
@Controller
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmasRepository turmasRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    //acesso do aluno à lista de ativiades
    @GetMapping("/listaAtividades")
    public String listagemAtividades(Model model){
        List<Atividade> listaAtividades= atividadeRepository.findAll();

        model.addAttribute("ListaAtividades", listaAtividades);

        return "/aluno/listaAtividades";
    }


    //visualização do aluno de uma atividade em específico

    @GetMapping("/visualizarAtividades/{titulo}")
    public String visualizarAtiv( @PathVariable("titulo") String titulo, Model model){
        Atividade atividade= atividadeRepository.findByTitulo(titulo);
        return "/aluno/visuAtividade";
    }


    //visualização do aluno da sua turma
    @GetMapping("/visuTurma/{nome}")
    public String visualizarTurma(@PathVariable("nome") String nome, Model model){
        Turmas turmas= turmasRepository.findByNome(nome);

        return "/administrador/alterarAluno";
    }


}
