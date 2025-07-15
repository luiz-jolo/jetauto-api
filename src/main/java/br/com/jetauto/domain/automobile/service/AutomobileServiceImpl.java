package br.com.jetauto.domain.automobile.service;

import br.com.jetauto.domain.automobile.Automobile;
import br.com.jetauto.domain.automobile.AutomobileImage;
import br.com.jetauto.domain.automobile.AutomobileImageRepository;
import br.com.jetauto.domain.automobile.AutomobileRepository;
import br.com.jetauto.domain.automobile.dto.AutomobileDetailsDto;
import br.com.jetauto.domain.automobile.dto.AutomobileDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import br.com.jetauto.domain.automobile.dto.validators.CreationValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private final List<CreationValidator> creationValidator;
    private final AutomobileRepository automobileRepository;

    private final AutomobileImageRepository automobileImageRepository;

    public AutomobileServiceImpl(List<CreationValidator> creationValidator, AutomobileRepository automobileRepository, AutomobileImageRepository automobileImageRepository) {
        this.creationValidator = creationValidator;
        this.automobileRepository = automobileRepository;
        this.automobileImageRepository = automobileImageRepository;
    }

    @Transactional
    @Override
    public Automobile create(CreateAutomobileDto createAutomobileDto) {
        //chain or responsability pattern
        creationValidator.forEach(v -> v.validate(createAutomobileDto));
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
    public Automobile createWithImages(CreateAutomobileDto createAutomobileDto, List<MultipartFile> images) {
        //chain or responsability pattern in validation
        creationValidator.forEach(v -> v.validate(createAutomobileDto));
        Automobile automobile = new Automobile(createAutomobileDto.model(),
                createAutomobileDto.brand(),
                createAutomobileDto.description(),
                createAutomobileDto.carBody(),
                createAutomobileDto.year(),
                createAutomobileDto.kilometerAge());

        automobileRepository.save(automobile);

        String uploadDir = "uploads";

        File uploadPath = new File(uploadDir);
        if(!uploadPath.exists()) uploadPath.mkdirs();

        for (MultipartFile image : images){
            try{
                String originalFilename = image.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
                String uniqueFilename = UUID.randomUUID().toString() + "." + extension;

                Path filePath = Paths.get(uploadDir, uniqueFilename);

                Files.write(filePath, image.getBytes());

                AutomobileImage automobileImage = new AutomobileImage();
                automobileImage.setFilePath(filePath.toString());
                automobileImage.setAutomobile(automobile);
                automobileImageRepository.save(automobileImage);

            }catch (IOException exception){
                throw new RuntimeException("Erro ao salvar imagem", exception);
            }
        }
        return automobile;
    }

    @Override
    public AutomobileDetailsDto automobileDetails(UUID id) {
        Automobile automobile = automobileRepository.getReferenceById(id);

        List<String> automobileImages = automobile.getAutomobileImages()
                .stream()
                .map(AutomobileImage::getFilePath)
                .toList();

        return new AutomobileDetailsDto(
                automobile.getId(),
                automobile.getModel(),
                automobile.getBrand(),
                automobile.getDescription(),
                automobile.getCarBody(),
                automobile.getYear(),
                automobile.getKilometerAge(),
                automobileImages);
    }
}