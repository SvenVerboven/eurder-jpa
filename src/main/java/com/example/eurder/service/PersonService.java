package com.example.eurder.service;

import com.example.eurder.domain.person.Person;
import com.example.eurder.domain.person.PersonRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@AllArgsConstructor
@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Collection<Person> findAll() {
        return Lists.newArrayList(personRepository.findAll());
    }
}
