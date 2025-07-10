package br.com.jetauto.controller;


import br.com.jetauto.domain.automobile.Automobile;
import br.com.jetauto.domain.automobile.dto.AutomobileDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import br.com.jetauto.domain.automobile.service.AutomobileService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/automobile")
public class AutomobileController {

    private final AutomobileService automobileService;

    AutomobileController(AutomobileService automobileService){
        this.automobileService = automobileService;
    }

    @PostMapping public ResponseEntity<Automobile> create(@RequestBody @Valid CreateAutomobileDto createAutomobileDto){
        return ResponseEntity.ok(automobileService.create(createAutomobileDto));
    }

    @PostMapping(value = "/with-images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Automobile> createWithImages(
            @RequestPart("data") @Valid CreateAutomobileDto createAutomobileDto,
            @RequestPart("images") List<MultipartFile> images
    ){
        return ResponseEntity.ok(automobileService.createWithImages(createAutomobileDto, images));
    }



    @GetMapping("/{id}")
    public ResponseEntity<AutomobileDto> automobileDetails(@PathVariable UUID id){
        return ResponseEntity.ok(automobileService.automobileDetails(id));
    }


}
