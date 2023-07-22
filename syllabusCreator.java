import java.sql.Date;
import java.util.Scanner;

class days{
    String[] date = new String[100]; 
    String[] assingment = new String[100]; 
}

public class syllabusCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    System.out.println("What would you like to go by?(e.g. Dr. Smith)");
    String professor = scanner.nextLine(); 

    System.out.println("What is the name of your class?");
    String subject = scanner.nextLine(); 

    System.out.println("What days and time will your class be held?(e.g MWF 2:00 - 3:00)");
    String schedule = scanner.nextLine(); 

    System.out.println("Where is your class held?");
    String location = scanner.nextLine(); 
    
    /*
     * File must take in month and day, assingment
     * The teacher will input the month, then the day, then the assingment
     * If they have submitted all their assingment they will simply type 'done'
     */

    
    System.out.print("Please submit your assingments,\n First type in the month and day(e.g January 23),\n"+
                        "Then input the assingment(e.g. Chapter 4, problems 29 - 42),\n input 'done' to finish\n");
    
    String input = "";    
    String line = "";
    days homework = new days(); 
    int i = -1;

    do{
        //System.out.println("inside the while loop");
        i = i + 1; 
        scanner.useDelimiter("\n"); 
        line = scanner.nextLine(); 
        if(line.equals("done"))
            break;
        homework.date[i] = line; 
        // System.out.println(homework.date[i]);
        // System.out.println("i = "+i);
        // System.out.println("line that is date = " +line);
        line = scanner.nextLine();
        if(line.equals("done")) 
            break; 
        homework.assingment[i] = line; 
        // System.out.println("homework i = "+homework.assingment[i]);
        // System.out.println("i = "+i);

    }while(!line.equals("done")); 

    System.out.println("If you would like to see a model of your syllabus please type 'Syllabus'.\n");
    line = scanner.nextLine(); 

    if(line.equals("Syllabus")){
        System.out.println();
        System.out.printf("%s\n%S\n%s\n%s\n\nSchedule\n", professor, subject, schedule, location);
        for(int j = 0; j < i; j++){
            System.out.printf("%s, %s\n", homework.date[j], homework.assingment[j]);
        }
    }
    
    System.out.println("\nfinished");
    } 
}
