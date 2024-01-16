package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.ZoneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ZoneService {
    Page<ZoneDto> findAll(Pageable pageable);

    List<ZoneDto> findByLocal(Optional<String> local, Optional<String> cep);

}
