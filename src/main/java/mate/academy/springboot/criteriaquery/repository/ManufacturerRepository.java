package mate.academy.springboot.criteriaquery.repository;

import mate.academy.springboot.criteriaquery.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name);
}
