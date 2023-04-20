import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Struct;
import java.util.Scanner;

class assignment {
    int day;
    String name;
    String month;
}

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Please input a file name: ");
        // String fileName = scanner.nextLine();
        String fileName = "syllabus.txt";

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

        System.out.printf("Subject: %s\n", subject);
        System.out.printf("Days: %s\n", days);
        System.out.printf("Location: %s\n", location);
        System.out.printf("Professor: %s\n", professor);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("We have finished the file");
        scanner.close();
        reader.close();
    }

}
