package com.example.eurder.domain.surveysubject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SurveySubjectRepository extends CrudRepository<SurveySubject, Integer> {
    @Query("SELECT MAX(ss.sequence) FROM SurveySubject ss")
    Integer findMaxSequence();
}
