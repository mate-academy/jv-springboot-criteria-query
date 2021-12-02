package mate.academy.springboot.criteriaquery.dto;

import lombok.Data;

@Data
public class PhoneRequestDto {
    private String model;
    private String maker;
    private String color;
    private String countryManufactured;
}
