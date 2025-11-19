package com.example.Futurify.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Getter
@Setter
@ToString
@Entity
@Table(name = "analise_curriculo")
public class AnaliseCurriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analise_curriculo")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"nome", "email", "area_atuacao", "nivel_carreira", "data_cadastro"})
    private Usuario usuario;

    @OneToOne(mappedBy = "analiseCurriculo")
    @JsonBackReference
    private Curriculo curriculo;

    @JsonProperty("caminho_arquivo")
    @NotNull(message = "Caminho do arquivo é obrigatório.")
    @Size(max = 255, message = "Caminho do arquivo deve ter no maximo 255 palavras")
    @Column(name = "caminho_arquivo", nullable = false, length = 255)
    private String caminhoArquivo;

    @JsonProperty("txt_extraido")
    @NotNull(message = "O texto extraido é obrigatório.")
    @Size(max = 500, message = "Caminho do arquivo deve ter no maximo 500 palavras")
    @Column(name = "txt_extraido", nullable = false, length = 500)
    private String txt_extraido;

    @JsonProperty("competencias_detectadas")
    @NotNull(message = "Competencias Detectadas sao obrigatórias.")
    @Size(max = 200, message = "Competencias Detectadas devem ter no maximo 200 palavras")
    @Column(name = "competencias_detectadas", nullable = false, length = 200)
    private String competencias_detectadas;

    @JsonProperty("experiencias_detectadas")
    @Size(max = 150, message = "Experiencias detectadas devem ter no maximo 150 palavras")
    @Column(name = "experiencias_detectadas", length = 150)
    private String experiencias_detectadas;

    @JsonProperty("nivel_senioridade")
    @Size(max = 50, message = "Nivel de senioridade deve ter no maximo 50 palavras")
    @Column(name = "nivel_senioridade", length = 50)
    private String nivel_senioridade;

    @JsonProperty("dt_analise")
    @NotNull(message = "A data de analise é obrigatória.")
    @PastOrPresent(message = "A data de analise não pode ser no futuro.")
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_analise", nullable = false)
    private Date dt_analise = new Date();
}
