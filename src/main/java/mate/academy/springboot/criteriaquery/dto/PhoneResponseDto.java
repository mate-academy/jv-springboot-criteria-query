package mate.academy.springboot.criteriaquery.dto;

import lombok.Data;

@Data
public class PhoneResponseDto {
    private Long id;
    private String model;
    private MakerResponseDto maker;
    private String color;
    private String countryManufactured;
}
