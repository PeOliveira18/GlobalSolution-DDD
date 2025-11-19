package com.example.Futurify.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "trilhas")
public class Trilhas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty("nome")
    @NotBlank(message = "O nome da trilha é obrigatório.")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres.")
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @JsonProperty("descricao")
    @Size(max = 1000, message = "A descrição pode ter no máximo 1000 caracteres.")
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @JsonProperty("nivel")
    @NotBlank(message = "O nível é obrigatório.")
    @Size(max = 50, message = "O nível deve ter no máximo 50 caracteres.")
    @Column(name = "nivel", nullable = false, length = 50)
    private String nivel;

    @JsonProperty("carga_horaria")
    @NotNull(message = "A carga horária é obrigatória.")
    @Min(value = 1, message = "A carga horária deve ser maior que zero.")
    @Column(name = "carga_horaria", nullable = false)
    private Integer carga_horaria;

    @JsonProperty("foco_principal")
    @Size(max = 100, message = "O foco principal deve ter no máximo 100 caracteres.")
    @Column(name = "foco_principal", length = 100)
    private String foco_principal;

    @ManyToMany
    @JoinTable(
            name = "trilha_competencia", // nome da tabela de junção
            joinColumns = @JoinColumn(name = "trilha_id"), // coluna que referencia Trilhas
            inverseJoinColumns = @JoinColumn(name = "competencia_id") // coluna que referencia Competencias
    )
    @JsonManagedReference
    private List<Competencias> competencias;



}
