package ru.netology.hibernatedaolayer.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernatedaolayer.entity.Person;
import ru.netology.hibernatedaolayer.repository.CrudPersonRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class MethodSecurityController {

    private final CrudPersonRepository personRepository;

    public MethodSecurityController(CrudPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Secured("ROLE_READ")
    @GetMapping("/by-city")
    public List<Person> findByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/by-age")
    public List<Person> findByAge(int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/by-name-and-surname")
    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/by-username")
    public String findByPhoneNumber(String username){
        return username;
    }
}
