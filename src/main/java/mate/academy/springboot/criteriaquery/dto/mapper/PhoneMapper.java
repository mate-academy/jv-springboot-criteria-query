package mate.academy.springboot.criteriaquery.dto.mapper;

import mate.academy.springboot.criteriaquery.dto.PhoneRequestDto;
import mate.academy.springboot.criteriaquery.dto.PhoneResponseDto;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.service.MakerService;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    private final MakerMapper makerMapper;
    private final MakerService makerService;

    public PhoneMapper(MakerMapper makerMapper, MakerService makerService) {
        this.makerMapper = makerMapper;
        this.makerService = makerService;
    }

    public PhoneResponseDto toResponseDto(Phone phone) {
        PhoneResponseDto responseDto = new PhoneResponseDto();
        responseDto.setId(phone.getId());
        responseDto.setModel(phone.getModel());
        responseDto.setMaker(makerMapper.toResponseDto(phone.getMaker()));
        responseDto.setColor(phone.getColor());
        responseDto.setCountryManufactured(phone.getCountryManufactured());
        return responseDto;
    }

    public Phone toModel(PhoneRequestDto requestDto) {
        Phone phone = new Phone();
        phone.setModel(phone.getModel());
        phone.setMaker(makerService.findByName(requestDto.getMaker()));
        phone.setColor(requestDto.getColor());
        phone.setCountryManufactured(requestDto.getCountryManufactured());
        return phone;
    }
}
