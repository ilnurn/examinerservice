package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.AmountMoreThanQuestionsNumbersException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{

private final List<Question> questions;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question remove(Question question) {
         questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion(int amount) {
        Random number = new Random();
        if(amount > questions.size()){
            throw new AmountMoreThanQuestionsNumbersException("Заданное число больше колличества вопросов");
        }
        return questions.get(number.nextInt(amount));
    }
}
