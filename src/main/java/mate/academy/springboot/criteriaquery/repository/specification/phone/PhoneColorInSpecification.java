package mate.academy.springboot.criteriaquery.repository.specification.phone;

import javax.persistence.criteria.CriteriaBuilder;
import mate.academy.springboot.criteriaquery.model.Phone;
import mate.academy.springboot.criteriaquery.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PhoneColorInSpecification implements SpecificationProvider<Phone> {
    private static final String FILTER_KEY = "colorIn";
    private static final String FIELD_NAME = "color";

    @Override
    public Specification<Phone> getSpecification(String[] colors) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<String> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : colors) {
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
