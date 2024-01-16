package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.AddressDto;
import br.com.fiap.parkingmanagement.model.dto.ZoneDto;
import br.com.fiap.parkingmanagement.model.entity.Zone;
import br.com.fiap.parkingmanagement.repository.ZoneRepository;
import br.com.fiap.parkingmanagement.service.ViaCepService;
import br.com.fiap.parkingmanagement.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;
    private final ViaCepService viaCepService;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ZoneServiceImpl(ZoneRepository zoneRepository, ViaCepService viaCepService, MongoTemplate mongoTemplate) {
        this.zoneRepository = zoneRepository;
        this.viaCepService = viaCepService;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<ZoneDto> findAll(Pageable pageable) {
        return convertPageZoneToDto(zoneRepository.findAll(pageable));
    }

    @Override
    public List<ZoneDto> findByLocal(Optional<String> local, Optional<String> cep) {

        Query query = new Query();

        if (cep.isPresent()) {
            AddressDto addressDto = viaCepService.searchAddressByCep(cep.get());
            query = getQueryByLocal(addressDto);
            List<Zone> result = mongoTemplate.find(query, Zone.class);
            return convertListZoneToDto(result);
        }

        if (local.isPresent()) {

            query.addCriteria(Criteria.where("local").regex(local.get().trim().toUpperCase(), "i"));

            AddressDto addressDto = new AddressDto();
            addressDto.setLogradouro(local.get().trim().toUpperCase());

            Query query2 = getQueryByLocal(addressDto);

            List<Zone> result = mongoTemplate.find(query2, Zone.class);

            return convertListZoneToDto(result);
        }

        return findAll(Pageable.unpaged()).getContent();
    }

    private static Query getQueryByLocal(AddressDto addressDto) {
        var START_INDEX = 1;
        var addressChunks = Arrays.asList(addressDto.getLogradouro().split(" "));
        var newAddressChunks = addressChunks.subList(START_INDEX, addressChunks.size());

        Query query = new Query();
        query.addCriteria(
                Criteria
                        .where("local")
                        .regex(
                                newAddressChunks.toString()
                                        .replace(",", "")
                                        .replace("[", "")
                                        .replace("]", "")
                                ,
                                "i"
                        )
        );
        return query;
    }


    private Page<ZoneDto> convertPageZoneToDto(Page<Zone> zones) {

        Page<ZoneDto> zonesDto = zones.map(zone -> {
            return new ZoneDto(
                    zone.getZoneId(),
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

    private List<ZoneDto> convertListZoneToDto(List<Zone> zones) {

        List<ZoneDto> zonesDto = zones.stream().map(zone -> {

            return new ZoneDto(
                    zone.getZoneId(),
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
                    zone.getR3HolidayValuePerHour() != null ? zone.getR3HolidayValuePerHour() : 0);

        }).collect(Collectors.toList());
        return zonesDto;

    }
}
