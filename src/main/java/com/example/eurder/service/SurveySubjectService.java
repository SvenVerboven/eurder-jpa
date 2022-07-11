package com.example.eurder.service;

import com.example.eurder.domain.surveysubject.SurveySubject;
import com.example.eurder.domain.surveysubject.SurveySubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class SurveySubjectService {

    private final SurveySubjectRepository surveySubjectRepository;

    public Collection<SurveySubject> findAll() {
        return (Collection<SurveySubject>) surveySubjectRepository.findAll();
    }
}
