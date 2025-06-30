package br.com.jetauto.domain.automobile.dto;

import br.com.jetauto.domain.automobile.CarBody;

public record CreateAutomobileDto(String model, String brand, String description, CarBody carBody, Integer year, Integer kilometerAge) {
}
