import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Struct;
//import java.util.Scanner;
import java.util.Scanner;

class assignment {
    String day;
    String name;

    String month;
}

public class main {
    public static void main(String[] args) throws Exception {
        //Scanner scanner = new Scanner(System.in);
        File fileName = new File("syllabus.txt");

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line, subject, location, professor, days, time, homework;

        assignment listOfAssignments[] = new assignment[50];

        subject = reader.readLine();
        days = reader.readLine();
        location = reader.readLine();
        professor = reader.readLine();
        
        while (!(line = reader.readLine()).equals("Schedule")) {
            continue;
        }
        
        // System.out.printf("Subject: %s\n", subject);
        // System.out.printf("Days: %s\n", days);
        // System.out.printf("Location: %s\n", location);
        // System.out.printf("Professor: %s\n", professor);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        int i = 0;
        Character letter; 
        while ((letter = (Character)reader.read())) {
            System.out.print(line);

            // int j = i;

            // String[] words;
            // words = line.split(" ");
            // System.out.println(words[0]);

            // System.out.println(words);
            // listOfAssignments[i].month = words[0];
            // listOfAssignments[i].day = words[1];
            // listOfAssignments[i].name = words[2];
            // j++;
            // i = j;
        }

        //scanner.close();
        reader.close();
    }

}
