package com.example.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.communication.models.Survey;
import com.example.communication.repositories.SurveyRepository;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public void createSurvey(Survey survey) {
        surveyRepository.save(survey);
    }

    public Survey getSurveyById(Long surveyId) {
        return surveyRepository.findById(surveyId)
                .orElseThrow(() -> new IllegalArgumentException("Survey not found"));
    }
}