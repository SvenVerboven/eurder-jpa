package com.example.eurder.domain.survey;

import com.example.eurder.domain.person.Person;
import com.example.eurder.domain.score.Score;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "SURVEY")
public class Survey {
    @Id
    @SequenceGenerator(name = "SURVEY_SEQUENCE", sequenceName = "SURVEY_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SURVEY_SEQUENCE")
    private int id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FK_PERSON_ID")
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    private Collection<Score> scores;
}
