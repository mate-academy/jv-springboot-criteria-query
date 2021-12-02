package mate.academy.springboot.criteriaquery.service;

import java.util.List;
import java.util.Map;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.repository.PhoneRepository;
import mate.academy.springboot.criteriaquery.repository.specification.SpecificationManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final SpecificationManager<Phone> phoneSpecificationManager;
    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(SpecificationManager<Phone> phoneSpecificationManager,
                            PhoneRepository phoneRepository) {
        this.phoneSpecificationManager = phoneSpecificationManager;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> findAll(Map<String, String> params) {
        Specification<Phone> specification = null;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            Specification<Phone> sp = phoneSpecificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = specification == null
                    ? Specification.where(sp) : specification.and(sp);
        }
        return phoneRepository.findAll(specification);
    }
}
