import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void createFile(String input, String filename) {
        try {
            //String filename= "SQLStatement.txt";
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(filename);
                System.out.println("File created: " + myObj.getName());
                myWriter.write(input);
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }

        }catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }


    }


}
