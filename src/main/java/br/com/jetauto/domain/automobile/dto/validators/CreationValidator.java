package br.com.jetauto.domain.automobile.dto.validators;

import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;

public interface CreationValidator {
    void validate(CreateAutomobileDto createAutomobileDto);
}
