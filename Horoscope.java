import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;

public class Horoscope {

    private static final String TARGET_STRING = "exit";

    public static void main(String[] args) {
        Horoscope horoscope = new Horoscope();
        horoscope.waitForString();
    }

    public void waitForString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birthdate (dd-MM), or type '" + TARGET_STRING + "' to exit:");

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(TARGET_STRING)) {
                System.out.println("Goodbye!");
                break;
            } else {
                try {
                    // Horoscope calculation
                    String horoscope = berekenHoroscoop(userInput);
                    if (!"none".equals(horoscope)) {
                        System.out.println("Your horoscope is: " + horoscope);
                    } else {
                        System.out.println("Invalid date format or constellation not found. Please use dd-MM.");
                    }
                } catch (ParseException e) {
                    System.out.println("Error parsing date. Please use dd-MM.");
                }
            }
        }

        scanner.close();
    }

    private String berekenHoroscoop(String inputDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = dateFormat.parse(inputDate + "-2024"); // Add a common year for processing

        // Convert Date to LocalDate
        LocalDate date = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Check the constellation based on the date
        switch (getConstellation(date)) {
            case "Aries":
                return "Aries horoscope information";
            case "Taurus":
                return "Taurus horoscope information";
            case "Gemini":
                return "Gemini horoscope information";
            case "Cancer":
                return "Cancer horoscope information";
            case "Leo":
                return "Leo horoscope information";
            case "Virgo":
                return "Virgo horoscope information";
            case "Libra":
                return "Libra horoscope information";
            case "Scorpio":
                return "Scorpio horoscope information";
            case "Sagittarius":
                return "Sagittarius horoscope information";
            case "Capricorn":
                return "Capricorn horoscope information";
            case "Aquarius":
                return "Aquarius horoscope information";
            case "Pisces":
                return "Pisces horoscope information";
            default:
                return "none";
        }
    }

    private String getConstellation(LocalDate date) {
        // Determine the constellation based on the date (ignoring the year)
        LocalDate modifiedDate = LocalDate.of(2024, date.getMonth(), date.getDayOfMonth());

        if ((modifiedDate.isAfter(LocalDate.of(2024, 3, 20)) && modifiedDate.isBefore(LocalDate.of(2024, 4, 20)))) {
            return "Aries";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 4, 19)) && modifiedDate.isBefore(LocalDate.of(2024, 5, 21)))) {
            return "Taurus";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 5, 20)) && modifiedDate.isBefore(LocalDate.of(2024, 6, 21)))) {
            return "Gemini";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 6, 20)) && modifiedDate.isBefore(LocalDate.of(2024, 7, 22)))) {
            return "Cancer";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 7, 21)) && modifiedDate.isBefore(LocalDate.of(2024, 8, 23)))) {
            return "Leo";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 8, 22)) && modifiedDate.isBefore(LocalDate.of(2024, 9, 23)))) {
            return "Virgo";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 9, 22)) && modifiedDate.isBefore(LocalDate.of(2024, 10, 23)))) {
            return "Libra";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 10, 22)) && modifiedDate.isBefore(LocalDate.of(2024, 11, 22)))) {
            return "Scorpio";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 11, 21)) && modifiedDate.isBefore(LocalDate.of(2024, 12, 22)))) {
            return "Sagittarius";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 12, 21)) || modifiedDate.isBefore(LocalDate.of(2024, 1, 20)))) {
            return "Capricorn";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 1, 19)) && modifiedDate.isBefore(LocalDate.of(2024, 2, 19)))) {
            return "Aquarius";
        } else if ((modifiedDate.isAfter(LocalDate.of(2024, 2, 18)) && modifiedDate.isBefore(LocalDate.of(2024, 3, 21)))) {
            return "Pisces";
        } else {
            return "none";
        }
    }
}
