package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.QuestionAddedYetException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        for (Question question2 : questions) {
            if (question2.equals(question1)) {
                throw new QuestionAddedYetException();
            }
        }
        questions.add(question1);
        return question1;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        for (Question question2 : questions) {
            if (question2.equals(question1)) {
                questions.remove(question1);
                break;
            } else {
                throw new QuestionAddedYetException();
            }
        }

        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random number = new Random();
        return questions.get(number.nextInt(questions.size()));
    }
}
