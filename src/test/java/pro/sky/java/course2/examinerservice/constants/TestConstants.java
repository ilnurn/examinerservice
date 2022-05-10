package pro.sky.java.course2.examinerservice.constants;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.List;

public class TestConstants {

    public static final String QUESTION1 = "Читаешь ли ты книги для детей от 3-х лет?";
    public static final String ANSWER1 = "Да, когда надо выглядеть умным.";
    public static final String QUESTION2 = "Носишь ли ты дырявые носки?";
    public static final String ANSWER2 = "Это мое больное место.";
    public static final String QUESTION3 = "Часто ли ты ходишь в гости?";
    public static final String ANSWER3 = "А что, по мне не видно?";
    public static final String QUESTION4 = "Делаешь ли ты прически в дорогих салонах?";
    public static final String ANSWER4 = "Моя прическа ясно говорит об этом.";
    public static final String QUESTION5 = "Каждый ли день ты чистишь зубы?";
    public static final String ANSWER5 = "Да, мне прописал это доктор.";
    public static final String QUESTION6 = "Ломается ли твоя ручка, когда ты долго пишешь?";
    public static final String ANSWER6 = "Нет, учитель ругает меня за это.";
    public static final String QUESTION7 = "Каждый ли день ты разбиваешь тарелки?";
    public static final String ANSWER7 = "Конечно, это самое прикольное занятие.";
    public static final List<Question> ALL_QUESTIONS_AND_ANSWERS = List.of(
            new Question(QUESTION1, ANSWER1),
            new Question(QUESTION2, ANSWER2),
            new Question(QUESTION3, ANSWER3),
            new Question(QUESTION4, ANSWER4),
            new Question(QUESTION5, ANSWER5),
            new Question(QUESTION6, ANSWER6),
            new Question(QUESTION7, ANSWER7)
    );
    public static final List<Question> QUESTION_AND_ANSWER_IN_LIST = List.of(
            new Question(QUESTION1, ANSWER1)
    );
}
