import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskValidator {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty();
    }

    public static LocalDate parseDueDate(String dueDateStr) {
        try {
            return LocalDate.parse(dueDateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean isValidPriority(String priority) {
        String[] validPriorities = {"Thấp", "Trung bình", "Cao"};
        for (String p : validPriorities) {
            if (p.equals(priority)) return true;
        }
        return false;
    }
}
