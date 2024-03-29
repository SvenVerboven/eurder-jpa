package com.example.eurder.api;

import com.example.eurder.domain.surveysubject.SurveySubject;
import com.example.eurder.service.SurveySubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(path = "/surveysubjects")
public class SurveySubjectController {

    private final SurveySubjectService surveySubjectService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SurveySubject create(@RequestBody SurveySubject surveySubject) {
        return surveySubjectService.create(surveySubject);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<SurveySubject> findAll() {
        return surveySubjectService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {
        this.surveySubjectService.deleteById(id);
    }
}
