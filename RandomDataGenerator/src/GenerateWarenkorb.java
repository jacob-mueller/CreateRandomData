import Arrays.Adress;
import Arrays.StudioNames;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateWarenkorb {

    FileManager fileManager = new FileManager();

    public static void main(String[] args) {

        String table = "\"PSE1\".\"Warenkorb\"";
        String insertStatement = "INSERT ALL \n ";

        for (int i = 0; i <4000; i++) {
            insertStatement += "INTO " + table + " VALUES ('" +
                     i + "', '" +
                    new Random().nextInt(2000)  + "') \n ";
        }

        FileManager.createFile(insertStatement.substring(0, insertStatement.length() - 3) +
                "\n select * from  dual;", "SQLWarenkorb.txt");
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
