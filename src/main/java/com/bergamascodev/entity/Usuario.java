package com.bergamascodev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "native", strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTime", foreignKey = @ForeignKey(name = "fkTime"), referencedColumnName = "id")
    private Time time;

    @Column(name = "nome")
    private String nome;

 /*   @Column(name = "dataNascimento")
    @JsonbDateFormat(value = "dd-MM-yyyy")
    private Date dataNascimento;*/

    @CreationTimestamp
    @Column(name = "dataCriacao")
    private Timestamp dataCriacao;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "ativo")
    private Boolean ativo;
}
