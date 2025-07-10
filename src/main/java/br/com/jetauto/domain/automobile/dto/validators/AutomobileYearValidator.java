package br.com.jetauto.domain.automobile.dto.validators;

import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AutomobileYearValidator implements CreationValidator{

    final int minYearPermited = 1900;

    @Override
    public void validate(CreateAutomobileDto createAutomobileDto){
        var now = LocalDateTime.now();
        int maxYearPermited = now.getYear() + 1;
        if (createAutomobileDto.year() > maxYearPermited){
            throw new IllegalArgumentException("The field year does not be superior than " + maxYearPermited);
        }
        if (createAutomobileDto.year() <= minYearPermited){
            throw new IllegalArgumentException("The field year must be above " + minYearPermited);
        }
    }
}
