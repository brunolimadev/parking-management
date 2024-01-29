package br.com.fiap.parkingmanagement.controller;


import br.com.fiap.parkingmanagement.model.dto.ZoneDto;
import br.com.fiap.parkingmanagement.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneService zoneService;

    @Autowired
    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public ResponseEntity<Page<ZoneDto>> findAll(Pageable pageable){

        Page<ZoneDto> zones = zoneService.findAll(pageable);

        return ResponseEntity.ok().body(zones);
    }

    @GetMapping("/local")
    public ResponseEntity<List<ZoneDto>> findByLocal(
            @RequestParam("filterByCep") Optional<String> cep,
            @RequestParam("filterByLocal") Optional<String> local
            ){

        List<ZoneDto> zones = zoneService.findByLocal(local, cep);
        return ResponseEntity.ok().body(zones);
    }
}
