import Arrays.Adress;
import Arrays.StudioNames;
import Arrays.Surname;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateApp {

    FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2019, 01, 01);
        LocalDate end = LocalDate.of(2020, 01, 01);
        LocalDate publishstart = LocalDate.of(2006, 01, 01);
        LocalDate publishend = LocalDate.of(2020, 12, 30);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        System.out.println(GenerateKunde.between(start, end));
        String table = "\"PSE1\".\"Kunde\"";
        String insertStatement = "INSERT ALL \n ";
        String[] surnames = new Surname().getSurnames();
        String[] appNames = new StudioNames().getNames();
        String[] adress = new Adress().getAdress();
        String[] gender = {"m", "f"};
        String[] category = {"Education", "Family", "Games", "Efficiency", "News", "Social"};
        System.out.println(surnames);
        for (int i = 0; i < 1000; i++) {
            insertStatement += "INTO " + table + " VALUES ('" +
                    i + "' , '" +
                    GenerateKunde.randomItem(appNames) + "', '" +
                    GenerateKunde.randomItem(surnames) + "', '" +
                    //Downloadlink +"', '"+
                    GenerateKunde.between(publishstart, publishend).format(formatters) + "', '" +
                    GenerateKunde.randomItem(category) + "', '" +
                    (Math.random() * 10) + "', '\n";
            //Jugendschutzklasse
            //Version
            //Betriebsstatus
            //Betriebssystem
        }

        FileManager.createFile(insertStatement.substring(0, insertStatement.length() - 3) + "\n select * from  dual;", "SQLApp" +
                ".txt");
    }
}
