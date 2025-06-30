package br.com.jetauto.controller;


import br.com.jetauto.domain.automobile.Automobile;
import br.com.jetauto.domain.automobile.dto.AutomobileDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import br.com.jetauto.domain.automobile.service.AutomobileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/automobile")
public class AutomobileController {

    private final AutomobileService automobileService;

    AutomobileController(AutomobileService automobileService){
        this.automobileService = automobileService;
    }

    @PostMapping ResponseEntity<Automobile> create(@RequestBody CreateAutomobileDto createAutomobileDto){
        return ResponseEntity.ok(automobileService.create(createAutomobileDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<AutomobileDto> automobileDetails(@PathVariable UUID id){
        return ResponseEntity.ok(automobileService.automobileDetails(id));
    }


}
