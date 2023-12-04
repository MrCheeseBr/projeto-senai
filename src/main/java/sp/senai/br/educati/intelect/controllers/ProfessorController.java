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
import sp.senai.br.educati.intelect.models.Professor;
import sp.senai.br.educati.intelect.models.Turmas;
import sp.senai.br.educati.intelect.repository.AlunoRepository;
import sp.senai.br.educati.intelect.repository.AtividadeRepository;
import sp.senai.br.educati.intelect.repository.TurmasRepository;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private TurmasRepository turmasRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private AtividadeRepository atividadeRepository;

    //acesso listas
    @GetMapping("/listaAtividades")
    public String listagemAtividades(Model model){
        List<Atividade> listaAtividades= atividadeRepository.findAll();

        model.addAttribute("ListaAtividadesProf", listaAtividades);

        return "/professor/listaAtividades";
    }

    @GetMapping("/listaTurma")
    public String listagemTurmas(Model model){
        List<Turmas> listaTurmas= turmasRepository.findAll();

        model.addAttribute("listaTurmasProf", listaTurmas);

        return "/professor/listaTurmas";
    }

    @GetMapping("/cadastrarAtividade")
    public String cadAtividade(Model model){
        model.addAttribute("cadAtividade", new Atividade());

        return "/professor/cadAtividade";
    }

    @PostMapping("/salvarAtividade")
    public String salvarAtividade(@Valid Atividade atividade, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/professor/cadAtividade";
        }
        //verifica se turmas foram selecionadas
        if(atividade.getTurmas()!= null){
            Turmas turmasBanco = turmasRepository.findById(atividade.getTurmas().get(0).getId()).orElseThrow(()
                    -> new IllegalArgumentException("ID Inválido")
            );

            //adiciona turma na lista de turma do cadastro da atividade
            atividade.addTurma(turmasBanco);

        }
        atividadeRepository.save(atividade);
        attributes.addFlashAttribute("mensagemAtividadeSalva", "Atividade salva com sucesso");
        return "redirect:/professor/cadAtividade";
    }

    @GetMapping("/alterarAtividade/{titulo}")
    public String alterarAtividade(@PathVariable("titulo") String titulo, Model model){

        Atividade atividade= atividadeRepository.findByTitulo(titulo);

        model.addAttribute("alterarAtividade", atividade);

        return "/professor/alterarAtividade";
    }

    @PostMapping("/alterarAtividade/{titulo}")
    public  String alterarProfessor(@PathVariable("titulo") String titulo, @Valid Atividade atividade, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()) {
            return "/professor/alterarAtividade";
        }

        Atividade atividadeAtualizada= atividadeRepository.findByTitulo(titulo);

        atividadeAtualizada.setTitulo(atividade.getTitulo());
        atividadeAtualizada.setId(atividade.getId());
        atividadeAtualizada.setTurmas(atividadeAtualizada.getTurmas());
        atividadeAtualizada.setData_conclusao(atividade.getData_conclusao());
        atividadeAtualizada.setData_inicio(atividade.getData_inicio());
        atividadeAtualizada.setDescricao(atividade.getDescricao());

        atividadeRepository.save(atividadeAtualizada);

        attributes.addFlashAttribute("mensagemAlterarAtividade", "Atividade atualizada com sucesso!");

        return "redirect:/professor/alterarAtividade";
    }
}
