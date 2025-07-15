package br.com.jetauto.domain.automobile.service;

import br.com.jetauto.domain.automobile.Automobile;
import br.com.jetauto.domain.automobile.dto.AutomobileDetailsDto;
import br.com.jetauto.domain.automobile.dto.AutomobileDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface AutomobileService {

    public Automobile create(CreateAutomobileDto createAutomobileDto);
    public Automobile createWithImages(CreateAutomobileDto createAutomobileDto, List<MultipartFile> images);
    public AutomobileDetailsDto automobileDetails(UUID id);

}
