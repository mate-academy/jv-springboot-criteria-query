package mate.academy.springboot.criteriaquery.dto;

import java.util.Set;
import lombok.Data;

@Data
public class PhoneResponseDto {
    private Long id;
    private String model;
    private MakerResponseDto maker;
    private Set<FeatureResponseDto> features;
    private String color;
    private String countryManufactured;
}
