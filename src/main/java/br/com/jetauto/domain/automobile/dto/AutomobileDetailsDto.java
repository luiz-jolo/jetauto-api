package br.com.jetauto.domain.automobile.dto;

import br.com.jetauto.domain.automobile.CarBody;

import java.util.List;
import java.util.UUID;

public record AutomobileDetailsDto(UUID id,
                                   String model,
                                   String brand,
                                   String description,
                                   CarBody carBody,
                                   Integer year,
                                   Integer kilometerAge,
                                   List<String> imageUrls) {
}
