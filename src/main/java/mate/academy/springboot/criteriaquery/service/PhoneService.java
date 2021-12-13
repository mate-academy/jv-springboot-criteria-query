package mate.academy.springboot.criteriaquery.service;

import java.util.List;
import java.util.Map;
import mate.academy.springboot.criteriaquery.model.Phone;

public interface PhoneService {
    Phone save(Phone phone);

    List<Phone> findAll(Map<String, String> params);
}
