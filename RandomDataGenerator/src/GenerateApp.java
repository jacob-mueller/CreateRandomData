import Arrays.Appinfo;
import Arrays.StudioNames;

import java.util.Random;

public class GenerateApp {

    FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        String table = "\"PSE1\".\"App\"";
        String insertStatement = "INSERT ALL \n ";
        String[] os = new String[]{"IOS", "Droid"};
        String [] devstudio = new  StudioNames().getNames();
        String[][] app = new Appinfo().getAppInfo();
        int ID = 1;
        for (int t = 0; t < 3; t++) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 106; i++) {
                    String status="";
                    if( (i+1)%12==0){status="inactive";}else {status="active";}
                    insertStatement += "INTO " + table + " VALUES ('" +
                            ID + "' , '" +
                            app[i][0] + "', '" +
                            createRandomURL() + "', '" +   //url
                            app[i][1] + "', '" +  //veröffentlichungsdatum
                            app[i][2] + "', '" +
                            app[i][3] + "', '" +
                            app[i][4] + "', '" +
                            app[i][5] + "', '" +
                            t + "', '" +
                            status + "', '" +
                            os[j] +"', '" +
                            randomItem(devstudio) +
                            "') \n";
                    ID++;
                }
            }
        }
        FileManager.createFile(insertStatement.substring(0, insertStatement.length() - 3) + ") \n select * from  dual;", "SQLApp" +
                ".txt");
    }


    public static String createRandomURL(){
        Random r = new Random();
        String url = "www.";
        String alphabet = "qwertzuioasdfhklgk123ymxncvb";
        for (int i = 0; i < 30; i++) {
            url += (alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return url +".de";
    }
    public static String randomItem(String[] list) {
        int randomPosition = new Random().nextInt(list.length);
        return list[randomPosition];
    }


}
