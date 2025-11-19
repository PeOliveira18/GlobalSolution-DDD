package com.example.Futurify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "curriculos")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curriculo")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_analise_curriculo")
    @JsonManagedReference
    @JsonIgnoreProperties({"caminho_arquivo", "txt_extraido", "competencias_detectadas", "experiencias_detectadas", "nivel_senioridade", "dt_analise"})
    private AnaliseCurriculo analiseCurriculo;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    @JsonManagedReference
    @JsonIgnoreProperties({"nome", "email", "area_atuacao", "nivel_carreira", "data_cadastro"})
    private Usuario usuario;

    @JsonProperty("titulo")
    @NotNull(message = "A data de ultima atualizacao é obrigatória.")
    @Size(max = 200, message = "Titulo deve ter no maximo 200 palavras")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @JsonProperty("resumo_profissional")
    @NotNull(message = "A data de ultima atualizacao é obrigatória.")
    @Size(max = 200, message = "Resumo Profissional deve ter no maximo 500 palavras")
    @Column(name = "resumo_profissional", nullable = false , length = 200)
    private String resumo_profissional;

    @JsonProperty("experiencias")
    @Size(max = 150, message = "Experiencias deve ter no maximo 150 palavras")
    @Column(name = "experiencias" , length = 150)
    private String experiencias;

    @JsonProperty("educacao")
    @NotNull(message = "A data de ultima atualizacao é obrigatória.")
    @Size(max = 150, message = "Educacao deve ter no maximo 150 palavras")
    @Column(name = "educacao", nullable = false , length = 150)
    private String educacao;

    @JsonProperty("habilidades")
    @NotNull(message = "A data de ultima atualizacao é obrigatória.")
    @Size(max = 200, message = "Habilidades deve ter no maximo 200 palavras")
    @Column(name = "habilidades", nullable = false , length = 200)
    private String habilidades;

    @JsonProperty("certificacoes")
    @Size(max = 200, message = "Certificacoes deve ter no maximo 200 palavras")
    @Column(name = "certificacoes", length = 200)
    private String certificacoes;

    @JsonProperty("ultima_atualizacao")
    @NotNull(message = "A data de ultima atualizacao é obrigatória.")
    @PastOrPresent(message = "A data de cadastro não pode ser no futuro.")
    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_atualizacao", nullable = false)
    private Date ultima_atualizacao = new Date();
}
