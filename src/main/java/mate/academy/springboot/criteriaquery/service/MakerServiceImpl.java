package mate.academy.springboot.criteriaquery.service;

import mate.academy.springboot.criteriaquery.model.Maker;
import mate.academy.springboot.criteriaquery.repository.MakerRepository;
import org.springframework.stereotype.Service;

@Service
public class MakerServiceImpl implements MakerService {
    private final MakerRepository makerRepository;

    public MakerServiceImpl(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    @Override
    public Maker save(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public Maker findByName(String name) {
        return makerRepository.findByName(name);
    }
}
