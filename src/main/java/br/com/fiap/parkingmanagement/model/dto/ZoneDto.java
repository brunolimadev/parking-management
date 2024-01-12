package br.com.fiap.parkingmanagement.model.dto;

public record ZoneDto(
        String id,
        String areaName,
        String local,
        String side,
        int qtdCarSpace,
        int qtTruckSpace,
        int qtChartedBusSpace,
        int qtElderlySpace,
        int qtDeficientSpace,
        int r1MaxTimeCar,
        String r1WeekStartTime,
        String r1WeekEndTime,
        double r1WeekValuePerHour,
        String r1SaturdayStartTime,
        String r1SaturdayEndTime,
        double r1SaturdayValuePerHour,
        String r1SundayStartTime,
        String r1SundayEndTime,
        double r1SundayValuePerHour,
        String r1HolidayStartTime,
        String r1HolidayEndTime,
        double r1HolidayValuePerHour,
        int r2MaxTimeCar,
        String r2WeekStartTime,
        String r2WeekEndTime,
        double r2WeekValuePerHour,
        String r2SaturdayStartTime,
        String r2SaturdayEndTime,
        double r2SaturdayValuePerHour,
        String r2SundayStartTime,
        String r2SundayEndTime,
        double r2SundayValuePerHour,
        String r2HolidayStartTime,
        String r2HolidayEndTime,
        double r2HolidayValuePerHour,
        int r3MaxTimeCar,
        String r3WeekStartTime,
        String r3WeekEndTime,
        double r3WeekValuePerHour,
        String r3SaturdayStartTime,
        String r3SaturdayEndTime,
        double r3SaturdayValuePerHour,
        String r3SundayStartTime,
        String r3SundayEndTime,
        double r3SundayValuePerHour,
        String r3HolidayStartTime,
        String r3HolidayEndTime,
        double r3HolidayValuePerHour
) {
}
