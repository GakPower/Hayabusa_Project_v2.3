package Core.DayConvertion;

import java.time.LocalDate;

public class DateConvertion {

    public static final String[] GREEK_DAYS = {
            "Δευτέρα",
            "Τρίτη",
            "Τετάρτη",
            "Πέμπτη",
            "Παρασκευή",
            "Σάββατο",
            "Κυριακή"
    };
    public static final String[] GREEK_MONTHS = {
            "Ιανουαρίου",
            "Φεβρουαρίου",
            "Μαρτίου",
            "Απριλίου",
            "Μαΐου",
            "Ιουνίου",
            "Ιουλίου",
            "Αυγούστου",
            "Σεπτεμβρίου",
            "Οκτωβρίου",
            "Νοεμβρίου",
            "Δεκεμβρίου",
    };

    public static String convert(LocalDate date)
    {
        String dayOfMonth = String.valueOf(date.getDayOfMonth());
        String month = GREEK_MONTHS[date.getMonthValue()-1];
        String day = GREEK_DAYS[date.getDayOfWeek().getValue()-1];
        String year = String.valueOf(date.getYear());

        return day +" "+ dayOfMonth +" "+ month +" "+ year;
    }
}
