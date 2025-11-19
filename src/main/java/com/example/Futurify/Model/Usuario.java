package com.example.Futurify.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonBackReference
    private Curriculo curriculo;

    @JsonProperty("nome")
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres.")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @JsonProperty("email")
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    @Size(max = 150, message = "O email deve ter no máximo 150 caracteres.")
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @JsonProperty("area_atuacao")
    @Size(max = 100, message = "A área de atuação deve ter no máximo 100 caracteres.")
    @Column(name = "area_atuacao", length = 100)
    private String area_atuacao;

    @JsonProperty("nivel_carreira")
    @Size(max = 50, message = "O nível de carreira deve ter no máximo 50 caracteres.")
    @Column(name = "nivel_carreira", length = 50)
    private String nivel_carreira;

    @JsonProperty("data_cadastro")
    @NotNull(message = "A data de cadastro é obrigatória.")
    @PastOrPresent(message = "A data de cadastro não pode ser no futuro.")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date data_cadastro = new Date();
}
