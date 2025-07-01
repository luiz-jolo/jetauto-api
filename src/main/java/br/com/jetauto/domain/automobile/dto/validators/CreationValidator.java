package br.com.jetauto.domain.automobile.dto.validators;

import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;

public interface CreationValidator {
    public void validate(CreateAutomobileDto createAutomobileDto);
}
