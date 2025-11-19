package com.example.Futurify.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "habilidades_emergentes")
public class HabilidadesEmergentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidades_emergentes")
    private Integer id;

    @JsonProperty("nome")
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 150, message = "O nome deve ter no maximo 150 caracteres.")
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @JsonProperty("categoria")
    @NotBlank(message = "Categoria é obrigatório.")
    @Size(max = 100, message = "Categoria deve ter no maximo 100 caracteres.")
    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;

    @JsonProperty("importancia_futura")
    @NotNull(message = "Importância futura é obrigatória.")
    @Min(value = 0, message = "O valor mínimo é 0.")
    @Max(value = 10, message = "O valor máximo é 10.")
    @Column(name = "importancia_futura", nullable = false)
    private Integer importancia_futura;

    @JsonProperty("descricao")
    @NotBlank(message = "Descricao é obrigatória.")
    @Size(max = 250, message = "Descricao deve ter no maximo 250 caracteres.")
    @Column(name = "descricao", nullable = false, length = 250)
    private String descricao;
}
