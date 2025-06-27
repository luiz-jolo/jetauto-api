package br.com.jetauto.domain.automobile.service;

import br.com.jetauto.domain.automobile.dto.AutomobileCreatedDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import org.springframework.stereotype.Service;

@Service
public class AutomobileServiceImpl implements AutomobileService{

    @Override
    public AutomobileCreatedDto create(CreateAutomobileDto createAutomobileDto){
        return new AutomobileCreatedDto("teste", "teste", "teste");
    }

}
