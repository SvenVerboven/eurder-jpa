package com.example.eurder.domain.question;

import com.example.eurder.domain.answer.Answer;
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
@Table(name = "QUESTION")
public class Question {
    @Id
    @SequenceGenerator(name = "QUESTION_SEQUENCE", sequenceName = "QUESTION_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "QUESTION_SEQUENCE")
    private int id;
    @Column(name = "TEXT")
    private String text;
    @ManyToMany()
    @JoinTable(name = "QUESTION_ANSWER",
            joinColumns = {@JoinColumn(name = "QUESTION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ANSWER_ID")})
    private List<Answer> answers;

}
