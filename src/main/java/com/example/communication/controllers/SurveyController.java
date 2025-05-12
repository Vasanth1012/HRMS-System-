package com.example.communication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.communication.models.Survey;
import com.example.communication.services.SurveyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/communication/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<String> conductSurvey(@RequestBody Survey survey) {
        surveyService.createSurvey(survey);
        return ResponseEntity.ok("Survey conducted successfully!");
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity<Survey> getSurveyResults(@PathVariable Long surveyId) {
        Survey survey = surveyService.getSurveyById(surveyId);
        if (survey == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(survey);
    }

}
