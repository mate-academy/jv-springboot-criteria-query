package mate.academy.springboot.criteriaquery.repository;

import mate.academy.springboot.criteriaquery.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhoneRepository extends JpaRepository<Phone, Long>,
        JpaSpecificationExecutor<Phone> {

}
