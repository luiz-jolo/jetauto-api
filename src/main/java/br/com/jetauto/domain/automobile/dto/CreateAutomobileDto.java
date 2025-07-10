package br.com.jetauto.domain.automobile.dto;

import br.com.jetauto.domain.automobile.CarBody;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAutomobileDto(
        @NotBlank(message = "Model is mandatory")
        String model,

        @NotBlank(message = "Brand is mandatory")
        String brand,

        @NotBlank(message = "Description is mandatory")
        String description,

        @NotNull(message = "Car body is mandatory")
        CarBody carBody,

        @NotNull(message = "Year is mandatory")
        Integer year,

        @NotNull(message = "Kilometer age is mandatory")
        Integer kilometerAge
){
}
