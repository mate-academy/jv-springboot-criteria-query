package mate.academy.springboot.criteriaquery.service;

import mate.academy.springboot.criteriaquery.model.Feature;
import mate.academy.springboot.criteriaquery.repository.FeatureRepository;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {
    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public Feature save(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature findById(Long id) {
        return featureRepository.getById(id);
    }

    @Override
    public Feature findByName(String name) {
        return featureRepository.findByName(name);
    }
}
