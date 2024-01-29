package br.com.fiap.parkingmanagement.enumerator;

public enum SearchLocalTypesEnum {
    BY_CEP("CEP"),
    BY_ZONE("ZONE");

    private final String type;

    SearchLocalTypesEnum(String type) {
        this.type = type;
    }
}
