package com.bergamascodev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"id"}, allowGetters = true, ignoreUnknown = true)
public class RegistroFormularioDto {

    private Long id;

    @NotNull
    private Long idFormulario;

    @NotNull
    private Long idPergunta;
}
