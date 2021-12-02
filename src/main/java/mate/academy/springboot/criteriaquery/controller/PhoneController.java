package mate.academy.springboot.criteriaquery.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import mate.academy.springboot.criteriaquery.dto.PhoneRequestDto;
import mate.academy.springboot.criteriaquery.dto.PhoneResponseDto;
import mate.academy.springboot.criteriaquery.dto.mapper.PhoneMapper;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.service.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    private final PhoneMapper phoneMapper;
    private final PhoneService phoneService;

    public PhoneController(PhoneMapper phoneMapper, PhoneService phoneService) {
        this.phoneMapper = phoneMapper;
        this.phoneService = phoneService;
    }

    @GetMapping("/inject")
    public String inject(@RequestParam(defaultValue = "100") Integer count) {
        String[] colors = {"red", "blue", "green", "yellow", "purple"};
        String[] makers = {"Apple", "Xiaomi", "Samsung", "Nokia", "Google"};
        for (int i = 0; i < count; i++) {
            Phone phone = new Phone();
            phone.setMaker(makers[new Random().nextInt(makers.length)]);
            phone.setModel(UUID.randomUUID().toString());
            phone.setColor(colors[new Random().nextInt(colors.length)]);
            phoneService.save(phone);
        }
        return "Created " + count + " phones!";
    }

    @PostMapping
    public PhoneResponseDto create(PhoneRequestDto requestDto) {
        return phoneMapper.toResponseDto(phoneService.save(phoneMapper.toModel(requestDto)));
    }

    @GetMapping
    public List<PhoneResponseDto> findAll(@RequestParam Map<String, String> params) {
        return phoneService.findAll(params).stream()
                .map(phoneMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}