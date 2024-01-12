package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.ZoneDto;
import br.com.fiap.parkingmanagement.model.entity.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZoneService {
    Page<ZoneDto> findAll(Pageable pageable);

}
