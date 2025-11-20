package com.example.Futurify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "progresso_trilha")
public class ProgressoTrilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progress_trilha")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({"nome", "email", "area_atuacao", "nivel_carreira", "data_cadastro"})
    @NotNull(message = "O usuário é obrigatório.")
    @JsonManagedReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_trilha", nullable = false)
    @JsonIgnoreProperties({"nome", "descricao", "nivel", "carga_horaria", "foco_principal", "competencias"})
    @NotNull(message = "A trilha é obrigatória.")
    private Trilhas trilhas;

    @JsonProperty("percentual")
    @NotNull(message = "Percentual de conclusão é obrigatório.")
    @DecimalMin(value = "0.00", message = "O percentual mínimo é 0.")
    @DecimalMax(value = "100.00", message = "O percentual máximo é 100.")
    @Column(name = "percentual", precision = 5, scale = 2, nullable = false)
    private BigDecimal percentual;


    @JsonProperty("ultima_atualizacao")
    @NotNull(message = "A data de ultima atualizacao é obrigatória.")
    @PastOrPresent(message = "A data de ultima atualizacao não pode ser no futuro.")
    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_atualizacao", nullable = false)
    private Date ultima_atualizacao = new Date();

}
