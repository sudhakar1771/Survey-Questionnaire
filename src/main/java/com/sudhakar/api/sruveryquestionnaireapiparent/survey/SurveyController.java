package com.sudhakar.api.sruveryquestionnaireapiparent.survey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public List<Question> retriveallquestions(@PathVariable String surveyid){
        List<Question> questions = surveyService.retriveallquestions(surveyid);
        if(questions == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return questions;
    }

    @RequestMapping("/surveys/{surveyid}/questions/{questionid}")
    public Question retrivequestionbyid(@PathVariable String surveyid, @PathVariable String questionid){
        Question specificquestion = surveyService.retrivequestionbyid(surveyid, questionid);

        if (specificquestion==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return specificquestion;
    }

    @RequestMapping(value = "/surveys/{surveyid}/questions", method = RequestMethod.POST)
    public ResponseEntity<Object> addQuestionToSurvey(@PathVariable String surveyid, @RequestBody Question question) {
        String questionId = surveyService.addquestiontosruvey(surveyid,question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{append}").buildAndExpand(questionId).toUri();
        return ResponseEntity.created(location).build();
    }
}
