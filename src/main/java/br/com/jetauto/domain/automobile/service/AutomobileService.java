package br.com.jetauto.domain.automobile.service;

import br.com.jetauto.domain.automobile.Automobile;
import br.com.jetauto.domain.automobile.dto.AutomobileDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;

import java.util.UUID;

public interface AutomobileService {

    public Automobile create(CreateAutomobileDto createAutomobileDto);

    public AutomobileDto automobileDetails(UUID id);

}
