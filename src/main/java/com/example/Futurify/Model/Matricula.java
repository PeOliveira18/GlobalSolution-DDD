package com.example.Futurify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties({"nome", "email", "area_atuacao", "nivel_carreira", "data_cadastro"})
    private Usuario usuario;


    @ManyToOne //
    @JoinColumn(name = "trilha_id", nullable = false)
//    @JsonIgnoreProperties({"id"})
    @JsonIgnoreProperties({"nome", "descricao", "nivel", "carga_horaria", "foco_principal"})
    private Trilhas trilha;

    @JsonProperty("data_inscricao")
    @NotNull(message = "A data de cadastro é obrigatória.")
    @PastOrPresent(message = "A data de cadastro não pode ser no futuro.")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inscricao", nullable = false)
    private Date data_inscricao = new Date();

    @JsonProperty("status")
    @Size(max = 50, message = "O status deve ter no máximo 50 caracteres.")
    @Column(name = "status", length = 50)
    private String status;

}
