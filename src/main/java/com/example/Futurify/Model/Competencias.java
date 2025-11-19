package com.example.Futurify.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "competencias")
public class Competencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty("nome")
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres.")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @JsonProperty("categoria")
    @Size(max = 100, message = "A área de atuação deve ter no máximo 100 caracteres.")
    @Column(name = "categoria", length = 100)
    private String categoria;

    @JsonProperty("descricao")
    @Size(max = 1000, message = "A descrição pode ter no máximo 1000 caracteres.")
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @ManyToMany(mappedBy = "competencias")
    @JsonBackReference
    private List<Trilhas> trilhas;
}
