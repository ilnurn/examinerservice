package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.AmountMoreThanQuestionsNumbersException;

import java.util.stream.Stream;

import static pro.sky.java.course2.examinerservice.constants.TestConstants.*;

public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    private static Stream<Arguments> provideParamsForTests(){
        return Stream.of(
                Arguments.of(QUESTION1, ANSWER1),
                Arguments.of(QUESTION2,ANSWER2),
                Arguments.of(QUESTION3, ANSWER3),
                Arguments.of(QUESTION4, ANSWER4),
                Arguments.of(QUESTION5, ANSWER5),
                Arguments.of(QUESTION6, ANSWER6),
                Arguments.of(QUESTION7, ANSWER7)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void ShouldAdd(String question, String answer){
        Assertions.assertEquals(out.add(question,answer), new Question(question, answer));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void ShouldRemove(String question, String answer){
        Question questionObject = new Question(question, answer);
        out.add(question,answer);
        out.remove(questionObject);
        Assertions.assertNull(out.getAll());
    }

    @Test
    public void ShouldGetAll(){
        out.add(QUESTION1,ANSWER1);
        out.add(QUESTION2,ANSWER2);
        out.add(QUESTION3,ANSWER3);
        out.add(QUESTION4,ANSWER4);
        out.add(QUESTION5,ANSWER5);
        out.add(QUESTION6,ANSWER6);
        out.add(QUESTION7,ANSWER7);
        Assertions.assertIterableEquals(out.getAll(),ALL_QUESTIONS_AND_ANSWERS);
    }

    @Test
    public void shouldThrowAmountMoreThanQuestionsNumbersException(){
        out.add(QUESTION1,ANSWER1);
        out.add(QUESTION2,ANSWER2);
        out.add(QUESTION3,ANSWER3);
        out.add(QUESTION4,ANSWER4);
        out.add(QUESTION5,ANSWER5);
        out.add(QUESTION6,ANSWER6);
        out.add(QUESTION7,ANSWER7);
        int amount = 8;
        Assertions.assertThrows(AmountMoreThanQuestionsNumbersException.class, () -> out.getRandomQuestion(amount));
    }
}
