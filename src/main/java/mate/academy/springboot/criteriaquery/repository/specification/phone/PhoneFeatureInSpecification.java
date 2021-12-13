package mate.academy.springboot.criteriaquery.repository.specification.phone;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.SetJoin;
import mate.academy.springboot.criteriaquery.model.Feature;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PhoneFeatureInSpecification implements SpecificationProvider<Phone> {
    private static final String FILTER_KEY = "featureIn";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Phone> getSpecification(String[] features) {
        return (root, query, cb) -> {
            SetJoin<Phone, Feature> phones = root.joinSet("features", JoinType.LEFT);
            CriteriaBuilder.In<String> predicate = cb.in(phones.get(FIELD_NAME));
            for (String value : features) {
                predicate.value(value);
            }
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
