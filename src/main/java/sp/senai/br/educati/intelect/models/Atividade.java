package sp.senai.br.educati.intelect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Integer data_conclusao;
    private Integer data_inicio;

    private String descricao;
    private String titulo;


    //get and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getData_conclusao() {
        return data_conclusao;
    }

    public void setData_conclusao(Integer data_conclusao) {
        this.data_conclusao = data_conclusao;
    }

    public Integer getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Integer data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
