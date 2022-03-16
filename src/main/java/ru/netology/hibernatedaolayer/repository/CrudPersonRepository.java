package ru.netology.hibernatedaolayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernatedaolayer.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
