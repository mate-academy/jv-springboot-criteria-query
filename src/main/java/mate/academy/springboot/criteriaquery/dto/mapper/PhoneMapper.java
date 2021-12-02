package mate.academy.springboot.criteriaquery.dto.mapper;

import java.util.stream.Collectors;
import mate.academy.springboot.criteriaquery.dto.PhoneRequestDto;
import mate.academy.springboot.criteriaquery.dto.PhoneResponseDto;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.service.FeatureService;
import mate.academy.springboot.criteriaquery.service.MakerService;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    private final FeatureMapper featureMapper;
    private final FeatureService featureService;
    private final MakerMapper makerMapper;
    private final MakerService makerService;

    public PhoneMapper(FeatureMapper featureMapper,
                       FeatureService featureService,
                       MakerMapper makerMapper,
                       MakerService makerService) {
        this.featureMapper = featureMapper;
        this.featureService = featureService;
        this.makerMapper = makerMapper;
        this.makerService = makerService;
    }

    public PhoneResponseDto toResponseDto(Phone phone) {
        PhoneResponseDto responseDto = new PhoneResponseDto();
        responseDto.setId(phone.getId());
        responseDto.setModel(phone.getModel());
        responseDto.setMaker(makerMapper.toResponseDto(phone.getMaker()));
        responseDto.setFeatures(phone.getFeatures().stream()
                .map(featureMapper::toResponseDto)
                .collect(Collectors.toSet()));
        responseDto.setColor(phone.getColor());
        responseDto.setCountryManufactured(phone.getCountryManufactured());
        return responseDto;
    }

    public Phone toModel(PhoneRequestDto requestDto) {
        Phone phone = new Phone();
        phone.setModel(phone.getModel());
        phone.setMaker(makerService.findById(requestDto.getMakerId()));
        phone.setFeatures(requestDto.getFeatureIds()
                .stream()
                .map(featureService::findById)
                .collect(Collectors.toSet()));
        phone.setColor(requestDto.getColor());
        phone.setCountryManufactured(requestDto.getCountryManufactured());
        return phone;
    }
}
