package web.service;

import org.junit.Assert;
import org.junit.Test;

public class DateQuestionServiceTest {

    @Test
    public void findDateAfterWithValidInputShouldAddDays() {
        Assert.assertEquals("2026-05-21", DateQuestionService.findDateAfter("2026-05-14", "7"));
    }

    @Test
    public void findDateAfterWithZeroDaysShouldReturnSameDate() {
        Assert.assertEquals("2026-05-14", DateQuestionService.findDateAfter("2026-05-14", "0"));
    }

    @Test
    public void findDateAfterWithMonthChangeShouldReturnCorrectDate() {
        Assert.assertEquals("2026-06-03", DateQuestionService.findDateAfter("2026-05-30", "4"));
    }

    @Test
    public void findDateAfterWithInvalidDateShouldReturnEmptyString() {
        Assert.assertEquals("", DateQuestionService.findDateAfter("wrong-date", "7"));
    }

    @Test
    public void findDateAfterWithInvalidDaysShouldTreatDaysAsZero() {
        Assert.assertEquals("2026-05-14", DateQuestionService.findDateAfter("2026-05-14", "abc"));
    }

    @Test
    public void findDateBeforeWithValidInputShouldSubtractDays() {
        Assert.assertEquals("2026-05-04", DateQuestionService.findDateBefore("2026-05-14", "10"));
    }

    @Test
    public void findDateBeforeWithMonthChangeShouldReturnCorrectDate() {
        Assert.assertEquals("2026-04-30", DateQuestionService.findDateBefore("2026-05-03", "3"));
    }

    @Test
    public void findDateBeforeWithEmptyDateShouldReturnEmptyString() {
        Assert.assertEquals("", DateQuestionService.findDateBefore("", "3"));
    }

    @Test
    public void correctDateAnswerShouldReturnTrue() {
        Assert.assertTrue(DateQuestionService.isDateAnswerCorrect("2026-05-21", "2026-05-21"));
    }

    @Test
    public void correctDateAnswerWithSpacesShouldReturnTrue() {
        Assert.assertTrue(DateQuestionService.isDateAnswerCorrect(" 2026-05-21 ", "2026-05-21"));
    }

    @Test
    public void wrongDateAnswerShouldReturnFalse() {
        Assert.assertFalse(DateQuestionService.isDateAnswerCorrect("2026-05-20", "2026-05-21"));
    }

    @Test
    public void emptyDateAnswerShouldReturnFalse() {
        Assert.assertFalse(DateQuestionService.isDateAnswerCorrect("", "2026-05-21"));
    }

    @Test
    public void emptyCorrectDateShouldReturnFalse() {
        Assert.assertFalse(DateQuestionService.isDateAnswerCorrect("2026-05-21", ""));
    }

    @Test
    public void nullCorrectDateShouldReturnFalse() {
        Assert.assertFalse(DateQuestionService.isDateAnswerCorrect("2026-05-21", null));
    }
}
