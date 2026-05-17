package web.service;

public class MathQuestionService {

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

    public static double q1Addition(String number1, String number2) {
        return parseNumber(number1) + parseNumber(number2);
    }

    public static double q2Subtraction(String number1, String number2) {
        return parseNumber(number1) - parseNumber(number2);
    }

    public static double q3Multiplication(String number1, String number2) {
        return parseNumber(number1) * parseNumber(number2);
    }

    public static boolean isAnswerCorrect(String userAnswer, double correctAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        try {
            double answer = Double.parseDouble(userAnswer.trim());
            return Double.compare(answer, correctAnswer) == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
