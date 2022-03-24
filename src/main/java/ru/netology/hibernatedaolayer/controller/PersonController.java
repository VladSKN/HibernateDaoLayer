//package ru.netology.hibernatedaolayer.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.netology.hibernatedaolayer.entity.Person;
//import ru.netology.hibernatedaolayer.repository.CrudPersonRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/persons")
//public class PersonController {
//
//    private final CrudPersonRepository personRepository;
//
//    public PersonController(CrudPersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @GetMapping("/by-city")             // без авторизации
//    public List<Person> findByCity(String city) {
//        return personRepository.findByCityOfLiving(city);
//    }
//
//    @GetMapping("/by-age")              // авторизация через пользователя user
//    public List<Person> findByAge(int age) {
//        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
//    }
//
//    @GetMapping("/by-name-and-surname") // авторизация через пользователя admin
//    public Optional<Person> findByNameAndSurname(String name, String surname) {
//        return personRepository.findByNameAndSurname(name, surname);
//    }
//}
