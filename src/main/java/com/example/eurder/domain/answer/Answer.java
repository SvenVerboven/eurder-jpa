package com.example.eurder.domain.answer;

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
@Table(name = "ANSWER")
public class Answer {
    @Id
    @SequenceGenerator(name = "ANSWER_SEQUENCE", sequenceName = "ANSWER_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ANSWER_SEQUENCE")
    private int id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SEQUENCE")
    private int sequence;
}
