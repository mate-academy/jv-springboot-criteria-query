package mate.academy.springboot.criteriaquery.service;

import mate.academy.springboot.criteriaquery.model.Maker;

public interface MakerService {
    Maker save(Maker maker);

    Maker findById(Long id);

    Maker findByName(String name);
}
