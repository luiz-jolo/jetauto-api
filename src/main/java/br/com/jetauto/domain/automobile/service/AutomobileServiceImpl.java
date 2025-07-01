package br.com.jetauto.domain.automobile.service;

import br.com.jetauto.domain.automobile.Automobile;
import br.com.jetauto.domain.automobile.AutomobileRepository;
import br.com.jetauto.domain.automobile.dto.AutomobileDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import br.com.jetauto.domain.automobile.dto.validators.CreationValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private CreationValidator creationValidator;
    private AutomobileRepository automobileRepository;

    public AutomobileServiceImpl(CreationValidator creationValidator, AutomobileRepository automobileRepository) {
        this.creationValidator = creationValidator;
        this.automobileRepository = automobileRepository;
    }

    @Transactional
    @Override
    public Automobile create(CreateAutomobileDto createAutomobileDto) {

        creationValidator.validate(createAutomobileDto);

        Automobile automobile = new Automobile(createAutomobileDto.model(),
                createAutomobileDto.brand(),
                createAutomobileDto.description(),
                createAutomobileDto.carBody(),
                createAutomobileDto.year(),
                createAutomobileDto.kilometerAge());

        automobileRepository.save(automobile);

        return automobile;

    }

    @Override
    public AutomobileDto automobileDetails(UUID id) {
        Automobile automobile = automobileRepository.getReferenceById(id);

        return new AutomobileDto(
                automobile.getId(),
                automobile.getModel(),
                automobile.getBrand(),
                automobile.getDescription(),
                automobile.getCarBody(),
                automobile.getYear(),
                automobile.getKilometerAge());
    }

}