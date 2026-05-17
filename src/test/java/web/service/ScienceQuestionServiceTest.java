package web.service;

import org.junit.Assert;
import org.junit.Test;

public class ScienceQuestionServiceTest {

    @Test
    public void calculateDensityWithValidValuesShouldReturnCorrectAnswer() {
        Assert.assertEquals(5.0, ScienceQuestionService.calculateDensity("50", "10"), 0.001);
    }

    @Test
    public void calculateDensityWithDecimalValuesShouldReturnCorrectAnswer() {
        Assert.assertEquals(3.0, ScienceQuestionService.calculateDensity("7.5", "2.5"), 0.001);
    }

    @Test
    public void calculateDensityWithZeroVolumeShouldReturnZero() {
        Assert.assertEquals(0.0, ScienceQuestionService.calculateDensity("50", "0"), 0.001);
    }

    @Test
    public void calculateDensityWithInvalidMassShouldTreatMassAsZero() {
        Assert.assertEquals(0.0, ScienceQuestionService.calculateDensity("abc", "10"), 0.001);
    }

    @Test
    public void calculateDensityWithInvalidVolumeShouldReturnZero() {
        Assert.assertEquals(0.0, ScienceQuestionService.calculateDensity("50", "abc"), 0.001);
    }

    @Test
    public void calculateDensityWithEmptyMassShouldTreatMassAsZero() {
        Assert.assertEquals(0.0, ScienceQuestionService.calculateDensity("", "10"), 0.001);
    }

    @Test
    public void correctScienceAnswerShouldReturnTrue() {
        Assert.assertTrue(ScienceQuestionService.isScienceAnswerCorrect("5", 5.0));
    }

    @Test
    public void correctScienceAnswerWithSmallDecimalDifferenceShouldReturnTrue() {
        Assert.assertTrue(ScienceQuestionService.isScienceAnswerCorrect("5.01", 5.0));
    }

    @Test
    public void wrongScienceAnswerShouldReturnFalse() {
        Assert.assertFalse(ScienceQuestionService.isScienceAnswerCorrect("6", 5.0));
    }

    @Test
    public void emptyScienceAnswerShouldReturnFalse() {
        Assert.assertFalse(ScienceQuestionService.isScienceAnswerCorrect("", 5.0));
    }

    @Test
    public void invalidScienceAnswerShouldReturnFalse() {
        Assert.assertFalse(ScienceQuestionService.isScienceAnswerCorrect("abc", 5.0));
    }

    @Test
    public void nullScienceAnswerShouldReturnFalse() {
        Assert.assertFalse(ScienceQuestionService.isScienceAnswerCorrect(null, 5.0));
    }
}
