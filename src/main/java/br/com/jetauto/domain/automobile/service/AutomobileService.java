package br.com.jetauto.domain.automobile.service;

import br.com.jetauto.domain.automobile.dto.AutomobileCreatedDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;

public interface AutomobileService {

    public AutomobileCreatedDto create(CreateAutomobileDto createAutomobileDto);

}
