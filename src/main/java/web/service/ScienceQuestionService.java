package web.service;

public class ScienceQuestionService {

    private static double parseNumber(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }

        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double calculateDensity(String mass, String volume) {
        double massValue = parseNumber(mass);
        double volumeValue = parseNumber(volume);

        if (volumeValue == 0) {
            return 0;
        }

        return massValue / volumeValue;
    }

    public static boolean isScienceAnswerCorrect(String userAnswer, double correctAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        try {
            double answer = Double.parseDouble(userAnswer.trim());
            return Math.abs(answer - correctAnswer) <= 0.01;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
