package com.example.eurder.service;

import com.example.eurder.domain.person.PersonRepository;
import com.example.eurder.domain.score.ScoreRepository;
import com.example.eurder.domain.survey.Survey;
import com.example.eurder.domain.survey.SurveyRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@AllArgsConstructor
@Service
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final PersonRepository personRepository;
    private final ScoreRepository scoreRepository;

    public Survey save(Survey survey) {
        personRepository.findById(survey.getPerson().getId()).ifPresent(survey::setPerson);
        return this.surveyRepository.save(survey);
    }

    public Collection<Survey> findAll() {
        return Lists.newArrayList(surveyRepository.findAll());
    }

    public void deleteAll() {
        surveyRepository.deleteAll();
    }

    public void deleteById(int id) {
        surveyRepository.deleteById(id);
    }
}
