package com.example.application.views.calendar;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import elemental.json.Json;
import elemental.json.JsonObject;
import org.vaadin.stefan.fullcalendar.*;
import org.vaadin.stefan.fullcalendar.dataprovider.EntryProvider;

import java.time.DayOfWeek;
import java.time.LocalDate;

@PageTitle("Calendar")
@Route(value = "calendar", layout = MainLayout.class)
public class Calendar extends VerticalLayout {

    private final FullCalendar calendar;


    public Calendar() {
        calendar = FullCalendarBuilder.create()
//                .withInitialOptions(defaultInitialOptions)
                .withEntryLimit(3)
                .build();
        calendar.setBusinessHours(new BusinessHours(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));

        setFlexGrow(1, calendar);
        setHorizontalComponentAlignment(Alignment.STRETCH, calendar);

        add(calendar);
        // Create a initial sample entry
        Entry entry = new Entry();
        entry.setTitle("Some event");
        entry.setColor("#ff3333");

// the given times will be interpreted as utc based - useful when the times are fetched from your database
        entry.setStart(LocalDate.now().withDayOfMonth(3).atTime(10, 0));
        entry.setEnd(entry.getStart().plusHours(2));

// FC uses a data provider concept similar to the Vaadin default's one, with some differences
// By default the FC uses a in-memory data provider, which is sufficient for most basic use cases.
        calendar.getEntryProvider().asInMemory().addEntries(entry);


        //buildSample(calendar);
    }

    protected FullCalendar createCalendar() {
        return new FullCalendar();
    }

    protected void buildSample(FullCalendar calendar){};

    protected FullCalendar addEntry(FullCalendar cal){
        cal.addClassName("TEST");
        return cal;
    }
}
