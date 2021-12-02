package mate.academy.springboot.criteriaquery.dto.mapper;

import mate.academy.springboot.criteriaquery.dto.MakerResponseDto;
import mate.academy.springboot.criteriaquery.model.Maker;
import org.springframework.stereotype.Component;

@Component
public class MakerMapper {
    public MakerResponseDto toResponseDto(Maker maker) {
        MakerResponseDto responseDto = new MakerResponseDto();
        responseDto.setId(maker.getId());
        responseDto.setName(maker.getName());
        return responseDto;
    }
}
