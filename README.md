#  Developing REST API Survey Questionnaire.

### Survey Questionnaire Data

```
Question question1  = new Question("Question1",
        "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
Question question2 = new Question("Question2",
        "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
Question question3 = new Question("Question3",
        "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

List<Question> questions = new ArrayList<>(Arrays.asList(question1,
        question2, question3));

Survey survey = new Survey("Survey1", "My Favorite Survey",
        "Description of the Survey", questions);

surveys.add(survey);

```

### URLs

#### Basic Authorization Header

- Authorization - Basic YWRtaW46cGFzc3dvcmQ=

#### GET

- http://localhost:8080/surveys
- http://localhost:8080/surveys/Survey1
- http://localhost:8080/surveys/Survey1/questions
- http://localhost:8080/surveys/Survey1/questions/Question1
- http://localhost:8080/userDetailses?size=1

##### Response

```
[
    {
        "id": "Survey1",
        "title": "My Favorite Survey",
        "description": "Description of the Survey",
        "questions": [
            {
                "id": "Question1",
                "description": "Most Popular Cloud Platform Today",
                "options": [
                    "AWS",
                    "Azure",
                    "Google Cloud",
                    "Oracle Cloud"
                ],
                "correctAnswer": "AWS"
            },
            {
                "id": "Question2",
                "description": "Fastest Growing Cloud Platform",
                "options": [
                    "AWS",
                    "Azure",
                    "Google Cloud",
                    "Oracle Cloud"
                ],
                "correctAnswer": "Google Cloud"
            },
            {
                "id": "Question3",
                "description": "Most Popular DevOps Tool",
                "options": [
                    "Kubernetes",
                    "Docker",
                    "Terraform",
                    "Azure DevOps"
                ],
                "correctAnswer": "Kubernetes"
            }
        ]
    }
]

```

#### DELETE

- http://localhost:8080/surveys/Survey1/questions/Question1

##### POST

**URL**: http://localhost:8080/surveys/Survey1/questions/
**Header**: Content-Type:application/json

**Request Body**
```
{
    "description": "Your Favorite Cloud Platform",
    "options": [
        "AWS",
        "Azure",
        "Google Cloud",
        "Oracle Cloud"
    ],
    "correctAnswer": "Google Cloud"
}

```

**URL**: http://localhost:8080/userDetailses
**Header**: Content-Type:application/json
**Request Body**
```
{
"name": "Sudhakar",
"role": "Admin"
}
```


##### PUT

**URL**: http://localhost:8080/surveys/Survey1/questions/Question1
**Header**: Content-Type:application/json
**Request Body**
```
{
    "id": "Question1",
    "description": "Most Popular Cloud Platform Today Change",
    "options": [
        "AWS",
        "Azure",
        "Google Cloud",
        "Oracle Cloud"
    ],
    "correctAnswer": "Google Cloud"
}

```