import java.io.*;
import java.util.Scanner;

class assignment {
    String day;
    String description;
    String month;
}


public class main{
    public static void main(String[] args) throws Exception{

        //declaring all necessary variables
        String line;
        int numOfAssignments = 0;

        //setting the filename
        String fileName = "syllabus.txt";

        //attempting to open the file
        File syll = new File(fileName);

        //checking if file is open and readable
        try {
            if (!syll.canRead()) {
                //throws exeption if file is not found
                throw new FileNotFoundException();
            }
        }catch (FileNotFoundException a){
            System.out.println("File Not Found: " + a);
        }

        //allocating memory in the heap for assignment classes
        assignment[] listOfAssignments = new assignment[50];

        //initializing all class assignments
        for(int i = 0; i < 50; i++){
            listOfAssignments[i] = new assignment();
        }

        //declaring and initializing scanner, named sc
        Scanner sc = new Scanner(syll);
        
        //skipping everything in file up to the schedule
        while(!(line = sc.nextLine()).equals("Schedule")){
            continue; 
        }

        //getting all the date for each assigment, and storing it in respective spot in listOfAssignment array
        while(sc.hasNextLine()) {
            //sets the delimeter as the space character so that it grabs just the words
            sc.useDelimiter(" ");

            //takes the data from file, will be the month assigment is due
            line = sc.next();
            //stores it in correct index of listOfAssignment array
            listOfAssignments[numOfAssignments].month = line;

            //takes next data from the file, will be the day assignment is due
            line = sc.next();
            listOfAssignments[numOfAssignments].day = line;
            
            //gets the description of assigment from the file
            line = sc.nextLine();
            //stores description in listOfAssignment array
            listOfAssignments[numOfAssignments].description = line;

            //increments numberOfAssignments
            numOfAssignments++;
        }


        //prints all data collected from the file to the console
        for(int k = 0; k < numOfAssignments; k++){
            System.out.println("Month: " + listOfAssignments[k].month);
            System.out.println("Day: " + listOfAssignments[k].day);
            System.out.println("Description: " + listOfAssignments[k].description);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("\n");
        }
        
        System.out.println("Number of assignments: " + numOfAssignments);
     }


}
