package mate.academy.springboot.criteriaquery.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import mate.academy.springboot.criteriaquery.dto.PhoneRequestDto;
import mate.academy.springboot.criteriaquery.dto.PhoneResponseDto;
import mate.academy.springboot.criteriaquery.dto.mapper.PhoneMapper;
import mate.academy.springboot.criteriaquery.model.Feature;
import mate.academy.springboot.criteriaquery.model.Maker;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.service.FeatureService;
import mate.academy.springboot.criteriaquery.service.MakerService;
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
    private final MakerService makerService;
    private final FeatureService featureService;

    public PhoneController(PhoneMapper phoneMapper, PhoneService phoneService,
                           MakerService makerService, FeatureService featureService) {
        this.phoneMapper = phoneMapper;
        this.phoneService = phoneService;
        this.makerService = makerService;
        this.featureService = featureService;
    }

    @GetMapping("/inject")
    public String inject(@RequestParam(defaultValue = "100") Integer count) {
        if (featureService.findByName("NFS") == null) {
            saveFeatures();
        }
        if (makerService.findByName("Apple") == null) {
            saveMakers();
        }
        String[] features = {"NFC", "autofocus", "flash", "stabilization"};
        String[] makers = {"Apple", "Xiaomi", "Samsung", "Nokia", "Google"};
        String[] colors = {"red", "blue", "green", "yellow", "purple"};
        Set<Feature> featureSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < new Random().nextInt(features.length); j++) {
                Feature feature = featureService.findByName(features[j]);
                featureSet.add(feature);
            }
            Phone phone = new Phone();
            phone.setMaker(makerService.findByName(makers[new Random().nextInt(makers.length)]));
            phone.setFeatures(featureSet);
            phone.setModel(UUID.randomUUID().toString());
            phone.setColor(colors[new Random().nextInt(colors.length)]);
            phoneService.save(phone);
        }
        return "Created " + count + " phones!";
    }

    private void saveFeatures() {
        String[] features = {"NFC", "autofocus", "flash", "stabilization"};
        for (String name : features) {
            Feature feature = new Feature();
            feature.setName(name);
            featureService.save(feature);
        }
    }

    private void saveMakers() {
        String[] makers = {"Apple", "Xiaomi", "Samsung", "Nokia", "Google"};
        for (String name : makers) {
            Maker maker = new Maker();
            maker.setName(name);
            makerService.save(maker);
        }
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
