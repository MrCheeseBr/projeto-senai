package sp.senai.br.educati.intelect.models;

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

}
