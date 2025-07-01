package br.com.jetauto.domain.automobile.dto.validators;

import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AutomobileYearValidator implements CreationValidator{

    @Override
    public void validate(CreateAutomobileDto createAutomobileDto){
        var now = LocalDateTime.now();
        int maxYearPermited = now.getYear() + 1;
        if (createAutomobileDto.year() > maxYearPermited){
            throw new IllegalArgumentException("The year dos not be superior than " + maxYearPermited);
        }
    }
}
