package com.sudhakar.api.sruveryquestionnaireapiparent.survey;


import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,question2,question3));

        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey",questions);

        surveys.add(survey);

    }

    public List<Survey> retriveallsurveys(){
        return surveys;
    }

    public Survey retrivespecificsurvey(String surveyid) {
        Predicate<? super Survey> predicate = survey -> surveyid.equals(survey.getId());
         Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();
         if (optionalSurvey.isEmpty()) return  null;
         return optionalSurvey.get();
    }

    public List<Question> retriveallquestions(String surveyid) {
        Survey survey = retrivespecificsurvey(surveyid);
        if (survey == null){
            return null;
        }
        return survey.getQuestions();
    }

    public Question retrivequestionbyid(String surveyid, String questionid) {
        List<Question> allquestions = retriveallquestions(surveyid);
        Optional<Question> question = allquestions.stream().filter(q -> questionid.equalsIgnoreCase(q.getId())).findFirst();
        if (question.isEmpty()){
            return null;
        }
        return question.get();
    }

    public String addquestiontosruvey(String surveyid, Question question) {
        List<Question> questions = retriveallquestions(surveyid);
        SecureRandom secureRandom = new SecureRandom();
        String randomid = new BigInteger(32,secureRandom).toString();
        question.setId(randomid);
        questions.add(question);
        return question.getId();
    }
}
