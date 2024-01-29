package br.com.fiap.parkingmanagement.controller;

import br.com.fiap.parkingmanagement.model.dto.VehicleDto;
import br.com.fiap.parkingmanagement.model.dto.VehicleListDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> create(@Valid @RequestBody VehicleDto request) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        vehicleService.save(request, user);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping
    public ResponseEntity<VehicleDto> update(@Valid @RequestBody VehicleDto request) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        VehicleDto vehicle = vehicleService.update(request, user);

        return ResponseEntity.status(HttpStatus.OK).body(vehicle);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        vehicleService.delete(id, user);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable String id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        VehicleDto vehicle = vehicleService.findById(id, user);

        return ResponseEntity.status(HttpStatus.OK).body(vehicle);

    }

    @GetMapping
    public ResponseEntity<VehicleListDto> findAll() {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<VehicleDto> vehicle = vehicleService.findAll(user);

        return ResponseEntity.status(HttpStatus.OK).body(new VehicleListDto(vehicle));

    }

}
