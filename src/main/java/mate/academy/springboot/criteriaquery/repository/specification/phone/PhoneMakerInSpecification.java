package mate.academy.springboot.criteriaquery.repository.specification.phone;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import mate.academy.springboot.criteriaquery.model.Maker;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PhoneMakerInSpecification implements SpecificationProvider<Phone> {
    private static final String FILTER_KEY = "makerIn";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Phone> getSpecification(String[] makers) {
        return (root, query, cb) -> {
            Join<Phone, Maker> join = root.join("maker", JoinType.INNER);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String value : makers) {
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
