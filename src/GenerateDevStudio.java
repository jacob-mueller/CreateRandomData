import Arrays.Adress;
import Arrays.Name;
import Arrays.StudioNames;
import Arrays.Surname;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateDevStudio {

    FileManager fileManager = new FileManager();

    public static void main(String[] args) {

        String table = "\"PSE1\".\"EntwicklerStudios\"";
        String insertStatement = "INSERT ALL \n ";
        String[] names = new StudioNames().getNames();
        String[] adress = new Adress().getAdress();
        for (int i = 0; i <names.length; i++) {
            insertStatement += "INTO " + table + " VALUES ('" +
                     names[i] + "', '" + randomItem(adress) + "') \n ";
        }

        FileManager.createFile(insertStatement.substring(0, insertStatement.length() - 3) +
                "\n select * from  dual;", "SQLEntwicklerstudio.txt");
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
