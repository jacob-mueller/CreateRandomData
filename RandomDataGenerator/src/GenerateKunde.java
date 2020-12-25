import Arrays.Adress;
import Arrays.Name;
import Arrays.Surname;
import Arrays.CategoryApp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateKunde {

    FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2019, 01, 01);
        LocalDate end = LocalDate.of(2020, 01, 01);
        LocalDate birthdaystart = LocalDate.of(1950, 01, 01);
        LocalDate birthdayend = LocalDate.of(2006, 01, 01);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        String table = "\"PSE1\".\"Kunde\"";
        String insertStatement = "INSERT ALL \n ";
        String[] surnames = new Surname().getSurnames();
        String[] names = new Name().getNames();
        String[] adress = new Adress().getAdress();
        String[] gender = {"m", "f"};
        String[] category = new CategoryApp().getCategory() ;
        for (int i = 0; i < 2000; i++) {
            insertStatement += "INTO " + table + " VALUES ('" +
                    i + "' , '" + randomItem(names) + "', '" + randomItem(surnames) + "', '" + randomItem(adress) +
                    "', '" + between(birthdaystart, birthdayend).format(formatters) + "', '" + randomItem(gender) + "', '" +
                    randomItem(category) + "', '" +
                    between(birthdaystart, birthdayend).format(formatters) + "') \n ";
        }

        FileManager.createFile(insertStatement.substring(0, insertStatement.length() - 3) +
                "\n select * from  dual;", "SQLKunde.txt");
    }

    public static String randomItem(String[] list) {
        int randomPosition = new Random().nextInt(list.length);
        return list[randomPosition];
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }


}
