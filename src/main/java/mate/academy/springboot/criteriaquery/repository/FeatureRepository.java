package mate.academy.springboot.criteriaquery.repository;

import mate.academy.springboot.criteriaquery.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    Feature findByName(String name);
}
