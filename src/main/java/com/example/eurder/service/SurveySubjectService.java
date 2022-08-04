package com.example.eurder.service;

import com.example.eurder.domain.question.QuestionRepository;
import com.example.eurder.domain.surveysubject.SurveySubject;
import com.example.eurder.domain.surveysubject.SurveySubjectRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class SurveySubjectService {

    private final SurveySubjectRepository surveySubjectRepository;
    private final QuestionRepository questionRepository;

    public Collection<SurveySubject> findAll() {
        return (Collection<SurveySubject>) surveySubjectRepository.findAll();
    }

    public void deleteById(int id) {
        surveySubjectRepository.deleteById(id);
    }

    public SurveySubject create(SurveySubject surveySubject) {
        Integer maxSequence = surveySubjectRepository.findMaxSequence();
        surveySubject.setSequence(Objects.isNull(maxSequence) ? 1 : ++maxSequence);
        surveySubject.setQuestions(Lists.newArrayList(questionRepository.findAll()));
        return surveySubjectRepository.save(surveySubject);
    }
}
