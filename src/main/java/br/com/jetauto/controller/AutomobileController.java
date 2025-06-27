package br.com.jetauto.controller;


import br.com.jetauto.domain.automobile.dto.AutomobileCreatedDto;
import br.com.jetauto.domain.automobile.dto.CreateAutomobileDto;
import br.com.jetauto.domain.automobile.service.AutomobileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/automobile")
public class AutomobileController {

    @GetMapping
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("pong");
    }

    private final AutomobileService automobileService;

    AutomobileController(AutomobileService automobileService){
        this.automobileService = automobileService;
    }

    @PostMapping ResponseEntity<AutomobileCreatedDto> create(@RequestBody CreateAutomobileDto createAutomobileDto){
        return ResponseEntity.ok(automobileService.create(createAutomobileDto));
    }

}
