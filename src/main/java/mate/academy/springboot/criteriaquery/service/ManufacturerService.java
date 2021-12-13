package mate.academy.springboot.criteriaquery.service;

import mate.academy.springboot.criteriaquery.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer save(Manufacturer manufacturer);

    Manufacturer findById(Long id);

    Manufacturer findByName(String name);
}
