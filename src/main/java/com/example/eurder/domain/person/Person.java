package com.example.eurder.domain.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @SequenceGenerator(name = "PERSON_SEQUENCE", sequenceName = "PERSON_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PERSON_SEQUENCE")
    private int id;
    @Column(name = "NAME")
    private String name;
}
