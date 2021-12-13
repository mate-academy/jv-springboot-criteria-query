package mate.academy.springboot.criteriaquery.service;

import mate.academy.springboot.criteriaquery.model.Feature;

public interface FeatureService {
    Feature save(Feature feature);

    Feature findById(Long id);

    Feature findByName(String name);
}
