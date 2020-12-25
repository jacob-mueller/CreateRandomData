import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateWarenkorbPosition {

    FileManager fileManager = new FileManager();

    public static void main(String[] args) {

        String table = "\"PSE1\".\"WarenkorbPosition\"";
        String insertStatement = "INSERT ALL \n ";

        for (int i = 0; i < 12000; i++) {
            insertStatement += "INTO " + table + " VALUES ('" +
                    i + "', '" +
                    new Random().nextInt(3) + "', '" +
                    new Random().nextInt(4000) + "', '" +
                    new Random().nextInt(3) + "') \n ";
        }

        FileManager.createFile(insertStatement.substring(0, insertStatement.length() - 3) +
                "\n select * from  dual;", "SQLWarenkorbposition.txt");
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
