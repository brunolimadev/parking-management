package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.ZoneDto;
import br.com.fiap.parkingmanagement.model.entity.Zone;
import br.com.fiap.parkingmanagement.repository.ZoneRepository;
import br.com.fiap.parkingmanagement.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;

    @Autowired
    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public Page<ZoneDto> findAll(Pageable pageable) {
        return convertPageZoneToDto(zoneRepository.findAll(pageable));
    }

    private Page<ZoneDto> convertPageZoneToDto(Page<Zone> zones) {

        Page<ZoneDto> zonesDto = zones.map(zone -> {
            return new ZoneDto(
                    zone.getId(),
                    zone.getAreaName(),
                    zone.getLocal(),
                    zone.getSide(),
                    zone.getQtdCarSpace(),
                    zone.getQtTruckSpace(),
                    zone.getQtChartedBusSpace(),
                    zone.getQtElderlySpace(),
                    zone.getQtDeficientSpace(),

                    zone.getR1MaxTimeCar(),

                    zone.getR1WeekStartTime(),
                    zone.getR1WeekEndTime(),
                    zone.getR1WeekValuePerHour() != null ? zone.getR1WeekValuePerHour() : 0,

                    zone.getR1SaturdayStartTime(),
                    zone.getR1SaturdayEndTime(),
                    zone.getR1SaturdayValuePerHour() != null ? zone.getR1SaturdayValuePerHour() : 0,

                    zone.getR1SundayStartTime(),
                    zone.getR1SundayEndTime(),
                    zone.getR1SundayValuePerHour() != null ? zone.getR1SundayValuePerHour() : 0,

                    zone.getR1HolidayStartTime(),
                    zone.getR1HolidayEndTime(),
                    zone.getR1HolidayValuePerHour() != null ? zone.getR1HolidayValuePerHour() : 0,

                    zone.getR2MaxTimeCar(),

                    zone.getR2WeekStartTime(),
                    zone.getR2WeekEndTime(),
                    zone.getR2WeekValuePerHour() != null ? zone.getR2WeekValuePerHour() : 0,

                    zone.getR2SaturdayStartTime(),
                    zone.getR2SaturdayEndTime(),
                    zone.getR2SaturdayValuePerHour() != null ? zone.getR2SaturdayValuePerHour() : 0,

                    zone.getR2SundayStartTime(),
                    zone.getR2SundayEndTime(),
                    zone.getR2SundayValuePerHour() != null ? zone.getR2SundayValuePerHour() : 0,

                    zone.getR2HolidayStartTime(),
                    zone.getR2HolidayEndTime(),
                    zone.getR2HolidayValuePerHour() != null ? zone.getR2HolidayValuePerHour() : 0,

                    zone.getR3MaxTimeCar(),

                    zone.getR3WeekStartTime(),
                    zone.getR3WeekEndTime(),
                    zone.getR3WeekValuePerHour() != null ? zone.getR3WeekValuePerHour() : 0,

                    zone.getR3SaturdayStartTime(),
                    zone.getR3SaturdayEndTime(),
                    zone.getR3SaturdayValuePerHour() != null ? zone.getR3SaturdayValuePerHour() : 0,

                    zone.getR3SundayStartTime(),
                    zone.getR3SundayEndTime(),
                    zone.getR3SundayValuePerHour() != null ? zone.getR3SundayValuePerHour() : 0,

                    zone.getR3HolidayStartTime(),
                    zone.getR3HolidayEndTime(),
                    zone.getR3HolidayValuePerHour() != null ? zone.getR3HolidayValuePerHour() : 0
            );
        });

        return zonesDto;

    }
}
