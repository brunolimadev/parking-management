package br.com.fiap.parkingmanagement.model.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Zone {
    @Id()
    ObjectId _id;
    String areaName;
    String local;
    String side;
    Integer qtdCarSpace;
    Integer qtTruckSpace;
    Integer qtChartedBusSpace;
    Integer qtElderlySpace;
    Integer qtDeficientSpace;
    Integer r1MaxTimeCar;
    String r1WeekStartTime;
    String r1WeekEndTime;
    Double r1WeekValuePerHour;
    String r1SaturdayStartTime;
    String r1SaturdayEndTime;
    Double r1SaturdayValuePerHour;
    String r1SundayStartTime;
    String r1SundayEndTime;
    Double r1SundayValuePerHour;
    String r1HolidayStartTime;
    String r1HolidayEndTime;
    Double r1HolidayValuePerHour;
    Integer r2MaxTimeCar;
    String r2WeekStartTime;
    String r2WeekEndTime;
    Double r2WeekValuePerHour;
    String r2SaturdayStartTime;
    String r2SaturdayEndTime;
    Double r2SaturdayValuePerHour;
    String r2SundayStartTime;
    String r2SundayEndTime;
    Double r2SundayValuePerHour;
    String r2HolidayStartTime;
    String r2HolidayEndTime;
    Double r2HolidayValuePerHour;
    Integer r3MaxTimeCar;
    String r3WeekStartTime;
    String r3WeekEndTime;
    Double r3WeekValuePerHour;
    String r3SaturdayStartTime;
    String r3SaturdayEndTime;
    Double r3SaturdayValuePerHour;
    String r3SundayStartTime;
    String r3SundayEndTime;
    Double r3SundayValuePerHour;
    String r3HolidayStartTime;
    String r3HolidayEndTime;
    Double r3HolidayValuePerHour;
    Long zoneId;
}
