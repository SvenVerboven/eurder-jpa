package com.example.eurder.domain.score;

import com.example.eurder.domain.question.Question;
import com.example.eurder.domain.surveysubject.SurveySubject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "SCORE")
public class Score {
    @Id
    @SequenceGenerator(name = "SCORE_SEQUENCE", sequenceName = "SCORE_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SCORE_SEQUENCE")
    private int id;
    @Column(name = "VALUE")
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "SURVEY_SUBJECT_ID")
    private SurveySubject surveySubject;
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
}
