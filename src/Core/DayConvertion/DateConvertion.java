package Core.DayConvertion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class DateConvertion {

    private static final ArrayList<String> GREEK_DAYS;
    private static final ArrayList<String> GREEK_MONTHS;

    static {
        GREEK_DAYS = new ArrayList<>();
        GREEK_DAYS.add("Δευτέρα");
        GREEK_DAYS.add("Τρίτη");
        GREEK_DAYS.add("Τετάρτη");
        GREEK_DAYS.add("Πέμπτη");
        GREEK_DAYS.add("Παρασκευή");
        GREEK_DAYS.add("Σάββατο");
        GREEK_DAYS.add("Κυριακή");

        GREEK_MONTHS = new ArrayList<>();
        GREEK_MONTHS.add("Ιανουαρίου");
        GREEK_MONTHS.add("Φεβρουαρίου");
        GREEK_MONTHS.add("Μαρτίου");
        GREEK_MONTHS.add("Απριλίου");
        GREEK_MONTHS.add("Μαΐου");
        GREEK_MONTHS.add("Ιουνίου");
        GREEK_MONTHS.add("Ιουλίου");
        GREEK_MONTHS.add("Αυγούστου");
        GREEK_MONTHS.add("Σεπτεμβρίου");
        GREEK_MONTHS.add("Οκτωβρίου");
        GREEK_MONTHS.add("Νοεμβρίου");
        GREEK_MONTHS.add("Δεκεμβρίου");
    }

    public static int getDayIndex(String dayName){
        return GREEK_DAYS.indexOf(dayName)+1;
    }
    public static int getMonthIndex(String monthName){
        return GREEK_MONTHS.indexOf(monthName)+1;
    }

    public static String convertToGreek(LocalDate date)
    {
        String day = GREEK_DAYS.get(date.getDayOfWeek().getValue()-1);
        String dayOfMonth = String.valueOf(date.getDayOfMonth());
        String month = GREEK_MONTHS.get(date.getMonthValue()-1);
        String year = String.valueOf(date.getYear());

        return day +" "+ dayOfMonth +" "+ month +" "+ year;
    }
    public static String convertToGreek(String EnglishDate){
        System.out.println("i am here2");
        String[] splited = EnglishDate.split("\\s+");

        String day = GREEK_DAYS.get(DayOfWeek.valueOf(splited[0]).getValue()-1);
        String dayOfMonth = splited[1];
        String month = GREEK_MONTHS.get(Month.valueOf(splited[2]).getValue()-1);
        String year = splited[3];

        return day +" "+ dayOfMonth +" "+ month +" "+ year;
    }

    public static String convertToEnglish(String greekDate){

        String[] splited = greekDate.split("\\s+");

        String day = DayOfWeek.of(getDayIndex(splited[0])).toString();
        String dayOfMonth = splited[1];
        String month = Month.of(getMonthIndex(splited[2])).toString();
        String year = splited[3];

        return day +" "+ dayOfMonth +" "+ month +" "+ year;
    }
}
