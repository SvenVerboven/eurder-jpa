package com.example.eurder.domain.surveysubject;

import com.example.eurder.domain.question.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SURVEY_SUBJECT")
public class SurveySubject {
    @Id
    @SequenceGenerator(name = "SURVEY_SUBJECT_SEQUENCE", sequenceName = "SURVEY_SUBJECT_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SURVEY_SUBJECT_SEQUENCE")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCE")
    private int sequence;
    @ManyToMany()
    @JoinTable(name = "SURVEY_SUBJECT_QUESTION",
            joinColumns = {@JoinColumn(name = "SURVEY_SUBJECT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID")})
    private List<Question> questions;
}
