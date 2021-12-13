package mate.academy.springboot.criteriaquery.dto.mapper;

import mate.academy.springboot.criteriaquery.dto.ManufacturerResponseDto;
import mate.academy.springboot.criteriaquery.model.Manufacturer;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper {
    public ManufacturerResponseDto toResponseDto(Manufacturer manufacturer) {
        ManufacturerResponseDto responseDto = new ManufacturerResponseDto();
        responseDto.setId(manufacturer.getId());
        responseDto.setName(manufacturer.getName());
        return responseDto;
    }
}
