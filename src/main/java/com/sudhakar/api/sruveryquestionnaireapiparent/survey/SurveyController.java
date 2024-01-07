package com.sudhakar.api.sruveryquestionnaireapiparent.survey;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class SurveyController {

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping("/surveys")
    public List<Survey> retriveallsurveys(){
        return surveyService.retriveallsurveys();
    }

    @RequestMapping("/surveys/{surveyid}")
    public Survey retrivespecificsurvey(@PathVariable String surveyid){
        Survey survey = surveyService.retrivespecificsurvey(surveyid);
        if (survey==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }

    @RequestMapping("/surveys/{surveyid}/questions")
    public Optional<List<Question>> retriveallquestions(@PathVariable String surveyid){
        return surveyService.retriveallquestions(surveyid);
    }

    @RequestMapping("/surveys/{surveyid}/questions/{questionid}")
    public Optional<Stream<Question>> retrivequestionbyid(@PathVariable String surveyid, @PathVariable String questionid){
        return surveyService.retrivequestionbyid(surveyid,questionid);
    }
}
