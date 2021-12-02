package mate.academy.springboot.criteriaquery.repository;

import mate.academy.springboot.criteriaquery.model.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakerRepository extends JpaRepository<Maker, Long> {
    Maker findByName(String name);
}
