package com.example.application.views.scanner;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@PageTitle("Scanner")
@Route(value = "scanner", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ScannerView extends VerticalLayout {


    public ScannerView() {

        Button print = new Button("Print to Screen");

        print.addClickListener(buttonClickEvent -> {
            int numAssignments = file.getNumOfAssignments();
            assignment[] listOfAssignments = file.getListOfAssignments();
            String recentMonth = "";
            String recentDay = "";
            String recentDescription = "";

            for (int k = 0; k < numAssignments; k++) {

                if(listOfAssignments[k].month.equals(recentMonth)){
                    // if we are still in the same month
                    if(listOfAssignments[k].day.equals(recentDay)){
                        // we are on the same day
                        recentDescription = listOfAssignments[k].description;
                        Paragraph desc = new Paragraph("    " + listOfAssignments[k].description);// print out the next assingment
                        add(desc);

                        // if its the same day but the same assingment just skip rewriting it
                        if(listOfAssignments[k].description.equals(recentDescription)) continue;
                    }
                    // if its the same month but not the same day we print out the day and assingment
                    recentDay = listOfAssignments[k].day;
                    System.out.println();
                    Paragraph assign = new Paragraph(listOfAssignments[k].day + ": " + listOfAssignments[k].description);
                    add(assign);
                }

                else{
                    // we are in a new month
                    recentMonth = listOfAssignments[k].month;
                    Paragraph filler = new Paragraph();
                    add(filler);

                    Paragraph month = new Paragraph(listOfAssignments[k].month);
                    add(month);

                    add(filler);
                    //System.out.println("\n\nMonth: " + listOfAssignments[k].month + "\n\n");
                    recentDay = listOfAssignments[k].day;
                    //System.out.print(listOfAssignments[k].day + ": ");
                    recentDescription = listOfAssignments[k].description;
                    //
                    // System.out.println(listOfAssignments[k].description);

                    Paragraph desc2 = new Paragraph(listOfAssignments[k].day + ": " + listOfAssignments[k].description);
                    add(desc2);
                }

            }


        });


        FileBuffer buffer = new FileBuffer();
        Upload upload = new Upload(buffer);

        upload.addSucceededListener(event -> {
            InputStream inputStream = buffer.getInputStream();
            String fileName = event.getFileName();
            System.out.println(fileName);
            try{
                file.processFile(inputStream);
            }catch (IOException e){
                System.out.println("ERROR: " + e);
            }

            //loading file
            try {
                file.getInfoPDF();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            //sorting file
            file.sort();


        });

//
//        VerticalLayout cal = new VerticalLayout();
//        // Create a new calendar instance and attach it to our layout
//        FullCalendar calendar = FullCalendarBuilder.create().build();
//
//        calendar.setHeightByParent(); // calculate the height by parent
//        calendar.getElement().getStyle().set("flex-grow", "1");
//
//        cal.setFlexGrow(1, calendar);
//        //cal.setHorizontalAlignment(Alignment.STRETCH);
//        calendar.set();
//
//// Variant 2: parent is a block container (e.g. normal Divs).
//// you can set the height in different ways
//        calendar.setHeight(500); // fixed pixel height
//        calendar.setHeightAuto(); // auto height
//        calendar.setHeightByParent(); // height by parent
//
//        calendar.setSizeFull();
//
//        cal.add(calendar);
//        cal.setFlexGrow(1, calendar);
//
//// Create a initial sample entry
//        Entry entry = new Entry();
//        entry.setTitle("Some event");
//        entry.setColor("#ff3333");
//
//// the given times will be interpreted as utc based - useful when the times are fetched from your database
//        entry.setStart(LocalDate.now().withDayOfMonth(3).atTime(10, 0));
//        entry.setEnd(entry.getStart().plusHours(2));
//        calendar.add();
//
//        calendar.addEntryClickedListener(event -> {
//            System.out.println("adding");
//        });

        add(upload);
        add(print);

        //add(cal);


        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }

}
