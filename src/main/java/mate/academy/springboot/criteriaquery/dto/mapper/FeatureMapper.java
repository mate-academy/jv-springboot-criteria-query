package mate.academy.springboot.criteriaquery.dto.mapper;

import mate.academy.springboot.criteriaquery.dto.FeatureResponseDto;
import mate.academy.springboot.criteriaquery.model.Feature;
import org.springframework.stereotype.Component;

@Component
public class FeatureMapper {
    public FeatureResponseDto toResponseDto(Feature feature) {
        FeatureResponseDto responseDto = new FeatureResponseDto();
        responseDto.setId(feature.getId());
        responseDto.setName(feature.getName());
        return responseDto;
    }
}
