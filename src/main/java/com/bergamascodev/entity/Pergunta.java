package com.bergamascodev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Pergunta")
public class Pergunta {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "native", strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    private Categoria categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "pontuacao")
    private BigDecimal pontuacao;

    @OneToMany(mappedBy = "pergunta")
    private Set<RegistroFormulario> registroFormularios;
}
