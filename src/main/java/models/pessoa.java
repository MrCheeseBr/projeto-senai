package models;

import enums.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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


public class pessoa {
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

    @NotEmpty(message = "Informe uma senha")
    private String senha;

    //get and setters

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
}
