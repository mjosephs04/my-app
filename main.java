import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.*;
import java.sql.Struct;
import java.util.Scanner;

class assignment {
    String day;
    String name;
    String month;
}

public class main {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        

    String data = readFileAsString("syllabus.txt");
    System.out.println(data);
    
     }

}
