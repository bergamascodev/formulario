package com.bergamascodev.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Registro_Formulario")
public class RegistroFormulario {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "native", strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formularioId")
    private Formulario formulario;

    @ManyToOne
    @JoinColumn(name = "perguntaId")
    private Pergunta pergunta;
}
