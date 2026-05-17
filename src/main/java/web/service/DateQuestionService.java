package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateQuestionService {

    private static LocalDate parseDate(String dateValue) {
        if (dateValue == null || dateValue.trim().isEmpty()) {
            return null;
        }

        try {
            return LocalDate.parse(dateValue.trim());
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static int parseDays(String daysValue) {
        if (daysValue == null || daysValue.trim().isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(daysValue.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String findDateAfter(String startDate, String days) {
        LocalDate date = parseDate(startDate);

        if (date == null) {
            return "";
        }

        int numberOfDays = parseDays(days);
        return date.plusDays(numberOfDays).toString();
    }

    public static String findDateBefore(String startDate, String days) {
        LocalDate date = parseDate(startDate);

        if (date == null) {
            return "";
        }

        int numberOfDays = parseDays(days);
        return date.minusDays(numberOfDays).toString();
    }

    public static boolean isDateAnswerCorrect(String userAnswer, String correctAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        if (correctAnswer == null || correctAnswer.trim().isEmpty()) {
            return false;
        }

        return userAnswer.trim().equals(correctAnswer.trim());
    }
}
