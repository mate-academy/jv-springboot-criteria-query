package mate.academy.springboot.criteriaquery.dto;

import java.util.Set;
import lombok.Data;

@Data
public class PhoneRequestDto {
    private String model;
    private Long manufacturerId;
    private Set<Long> featureIds;
    private String color;
    private String countryManufactured;
}
