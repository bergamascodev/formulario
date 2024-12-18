package com.bergamascodev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Formulario")
public class Formulario {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "native", strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataCriacao")
    @CreationTimestamp
    private Timestamp dataCriacao;

    @Column(name = "totalPontuacao")
    private BigDecimal totalPontuacao;

    @Column(name = "ativo")
    private Boolean ativo;

    @OneToMany(mappedBy = "formulario")
    private Set<RegistroFormulario> registroFormularios;
}
