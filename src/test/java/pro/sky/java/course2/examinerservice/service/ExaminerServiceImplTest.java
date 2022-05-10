package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.AmountMoreThanQuestionsNumbersOrLessOneException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.examinerservice.constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(-2),
                Arguments.of(-1),
                Arguments.of(0),
                Arguments.of(8),
                Arguments.of(9)
        );
    }

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void shouldGetQuestions() {
        when(questionServiceMock.getAll())
                .thenReturn(ALL_QUESTIONS_AND_ANSWERS);
        when(questionServiceMock.getRandomQuestion())
                .thenReturn(new Question(QUESTION1, ANSWER1));
        assertIterableEquals(out.getQuestions(1), QUESTION_AND_ANSWER_IN_LIST);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldThrowAmountMoreThanQuestionsNumbersException(int amount) {
        when(questionServiceMock.getAll())
                .thenReturn(ALL_QUESTIONS_AND_ANSWERS);
        Assertions.assertThrows(AmountMoreThanQuestionsNumbersOrLessOneException.class, () -> out.getQuestions(amount));
    }
}
