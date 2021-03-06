# CriteriaQuery in SpringBoot

In this repo you can find the example how to configure CriteriaQuery and use it with Spring Data JPA. 
Also, you can check more details in [this article](https://spring.io/blog/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl/).

#### NOTE: in this repo are not covered the following cases:
- CriteriaBuilder `or` case. But we are using `in` predicate, so pay attention to this.

### How to start?
- Launch the app
- Go to the `inject` endpoint to inject some data. 
For example to save 200 phone send following GET request:```http://localhost:8080/phones/inject?count=200```
- Send GET request to fetch some filtered data. For example:
    - to fetch all phones produced my Apple: `http://localhost:8080/phones?manufacturerIn=Apple`
    - to fetch all blue or green phones produced my Samsung: `http://localhost:8080/phones?manufacturerIn=Samsung&colorIn=blue,green`
    - to fetch all yellow phones produced my Apple with `flash` feature: `http://localhost:8080/phones?featureIn=flash&manufacturerIn=Apple&colorIn=yellow`
- Pay attention to `mate.academy.springboot.criteriaquery.repository.specification.phone.PhoneManufacturerInSpecification` class, where INNER JOIN is implemented
- Pay attention to `mate.academy.springboot.criteriaquery.repository.specification.phone.PhoneFeatureInSpecification` class, where Set<Feature> is used in filtering
