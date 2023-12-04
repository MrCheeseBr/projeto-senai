package sp.senai.br.educati.intelect.models;

import sp.senai.br.educati.intelect.enums.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipoPessoa",
        length = 1,
        discriminatorType = DiscriminatorType.STRING
)


public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Informe um nome")
    private String nome;

    @NotEmpty(message = "Informe a data de nascimento")
    private Integer data_nascimento;

    @NotEmpty(message = "Informe um CPF")
    @CPF(message = "O CPF informado é inválido")
    private Integer cpf;

    @NotEmpty(message = "Informe o RG")
    private Integer rg;

    @NotEmpty(message = "Informe um perfil")
    private Perfil perfil;

    @NotEmpty(message = "Informe um telefone")
    private Long telefone;

    @NotEmpty(message = "Informe um e-mail")
    @Email(message = "O e-mail informado é inválido")
    private String email;

    private String senha;

    @ManyToMany(mappedBy = "pessoas")
    private List<Turmas> turmas;

    @NotEmpty(message = "Informe um endereço")
    private String endereco;

    //get and setters

    public void addTurma(Turmas turma){
        turma.getPessoas().add(this);
        this.turmas.add(turma);
    }

    public void removeTurma(Turmas turma){
        turma.getPessoas().remove(this);
        this.turmas.remove(turma);
    }

    public List<Turmas> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turmas> turmas) {
        this.turmas = turmas;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Integer data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
