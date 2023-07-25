import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

class days {
    String[] date = new String[60];
    String[] assingment = new String[60];
}

public class syllabusCreator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to go by?(e.g. Dr. Smith)");
        String professor = scanner.nextLine();

        System.out.println("What is the name of your class?");
        String subject = scanner.nextLine();

        System.out.println("What days and time will your class be held?(e.g MWF 2:00 - 3:00)");
        String schedule = scanner.nextLine();

        System.out.println("Where is your class held?");
        String location = scanner.nextLine();

        System.out.print("\nPlease submit your assingments,\nFirst type in the month and day(e.g January 23),\n" +
                "Then input the assingment(e.g. Chapter 4, problems 29 - 42),\nInput 'done' to finish\n");

        String line = "";
        days homework = new days();
        int i = -1;

        do {
            i = i + 1;
            scanner.useDelimiter("\n");
            line = scanner.nextLine();
            if (line.equals("done"))
                break;
            homework.date[i] = line;
            line = scanner.nextLine();
            if (line.equals("done"))
                break;
            homework.assingment[i] = line;

        } while (!line.equals("done"));

        // System.out.println("If you would like to see a model of your syllabus please
        // type 'Syllabus'.\n");
        // line = scanner.nextLine();
        // scanner.close();

        // if(line.equals("Syllabus")){
        // System.out.println();
        // System.out.printf("%s\n%S\n%s\n%s\n\nSchedule\n", professor, subject,
        // schedule, location);
        // for(int j = 0; j < i; j++){
        // System.out.printf("%s, %s\n", homework.date[j], homework.assingment[j]);
        // }
        // }

        PDDocument document = new PDDocument();

        PDPage page = new PDPage();

        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        float x = 50;
        float y = 750;
        float spacing = 15;

        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(professor);
        contentStream.endText();

        y = y - spacing;

        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(subject);
        contentStream.endText();

        y = y - spacing;

        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(schedule);
        contentStream.endText();

        y = y - spacing;

        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(location);
        contentStream.endText();

        y = y - spacing * 2;

        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText("Schedule");
        contentStream.endText();

        for (int k = 0; k < i; k++) {
            y = y - spacing;
            contentStream.beginText();
            contentStream.newLineAtOffset(x, y);
            contentStream.showText(homework.date[k] + ", " + homework.assingment[k]);
            contentStream.endText();
        }

        contentStream.close();
        document.save(new File("syllabusPractice.pdf"));

        document.close();

        System.out.println("\nfinished");
    }
}
