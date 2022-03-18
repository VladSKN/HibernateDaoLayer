package ru.netology.hibernatedaolayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernatedaolayer.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "select p from Person p where p.cityOfLiving = :cityOfLiving")
    List<Person> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

    @Query(value = "select p from Person p where p.age <= :age order by p.age asc")
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Query(value = "select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name")String name, @Param("surname") String surname);
}
