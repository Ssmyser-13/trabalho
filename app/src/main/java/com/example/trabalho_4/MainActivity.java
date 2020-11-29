package com.example.trabalho_4;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                final CompactCalendarView compactCalendarView = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
                // Set first day of week to Monday, defaults to Monday so calling setFirstDayOfWeek is not necessary
                // Use constants provided by Java Calendar class
                compactCalendarView.setFirstDayOfWeek(Calendar.MONDAY);

                // Add event 1 on Sun, 07 Jun 2015 18:20:51 GMT
                Event ev1 = new Event(Color.GREEN, 1433701251000L, "Some extra data that I want to store.");
                compactCalendar.addEvent(ev1);

                // Added event 2 GMT: Sun, 07 Jun 2015 19:10:51 GMT
                Event ev2 = new Event(Color.GREEN, 1433704251000L);
                compactCalendar.addEvent(ev2);

                // Query for events on Sun, 07 Jun 2015 GMT.
                // Time is not relevant when querying for events, since events are returned by day.
                // So you can pass in any arbitary DateTime and you will receive all events for that day.
                List<Event> events = compactCalendar.getEvents(1433701251000L); // can also take a Date object

                // events has size 2 with the 2 events inserted previously
                Log.d(TAG, "Events: " + events);

                // define a listener to receive callbacks when certain events happen.
                compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
                        @Override
                        public void onDayClick(Date dateClicked) {
                                List<Event> events = compactCalendarView.getEvents(dateClicked);
                                Log.d(TAG, "Day was clicked: " + dateClicked + " with events " + events);
                        }

                        @Override
                        public void onMonthScroll(Date firstDayOfNewMonth) {
                                Log.d(TAG, "Month was scrolled to: " + firstDayOfNewMonth);
                        }
                });
        }
}

