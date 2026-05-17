package web.service;

import org.junit.Assert;
import org.junit.Test;

public class MathQuestionServiceTest {

    @Test
    public void q1AdditionWithValidNumbersShouldReturnCorrectAnswer() {
        Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.001);
    }

    @Test
    public void q1AdditionWithEmptyFirstNumberShouldTreatEmptyAsZero() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("", "3"), 0.001);
    }

    @Test
    public void q1AdditionWithInvalidFirstNumberShouldTreatInvalidAsZero() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("abc", "3"), 0.001);
    }

    @Test
    public void q2SubtractionWithValidNumbersShouldReturnCorrectAnswer() {
        Assert.assertEquals(5.0, MathQuestionService.q2Subtraction("8", "3"), 0.001);
    }

    @Test
    public void q2SubtractionWithEmptySecondNumberShouldTreatEmptyAsZero() {
        Assert.assertEquals(8.0, MathQuestionService.q2Subtraction("8", ""), 0.001);
    }

    @Test
    public void q3MultiplicationWithValidNumbersShouldReturnCorrectAnswer() {
        Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("4", "3"), 0.001);
    }

    @Test
    public void q3MultiplicationWithEmptyNumberShouldReturnZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("", "3"), 0.001);
    }

    @Test
    public void correctAnswerShouldReturnTrue() {
        Assert.assertTrue(MathQuestionService.isAnswerCorrect("5", 5.0));
    }

    @Test
    public void wrongAnswerShouldReturnFalse() {
        Assert.assertFalse(MathQuestionService.isAnswerCorrect("10", 5.0));
    }

    @Test
    public void emptyAnswerShouldReturnFalse() {
        Assert.assertFalse(MathQuestionService.isAnswerCorrect("", 5.0));
    }

    @Test
    public void invalidAnswerShouldReturnFalse() {
        Assert.assertFalse(MathQuestionService.isAnswerCorrect("abc", 5.0));
    }

    @Test
    public void nullAnswerShouldReturnFalse() {
        Assert.assertFalse(MathQuestionService.isAnswerCorrect(null, 5.0));
    }
}
