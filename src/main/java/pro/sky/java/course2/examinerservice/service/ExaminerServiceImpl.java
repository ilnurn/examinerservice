package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    Set<Question> randomQuestions = new HashSet<>();

    @Override
    public Collection<Question> getQuestions(int amount) {
        randomQuestions.add(questionService.getRandomQuestion(amount));
        return randomQuestions;
    }
}
