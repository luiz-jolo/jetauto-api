package br.com.jetauto.domain.automobile.dto;

import br.com.jetauto.domain.automobile.CarBody;

import java.util.UUID;

public record AutomobileDto(UUID id, String model, String brand, String description, CarBody carBody, Integer year, Integer kilometerAge) {
}
