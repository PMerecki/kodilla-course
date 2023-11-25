package com.kodilla;

import java.util.*;
import java.time.*;

public class ClocksCollectionApplication {

    public static void main(String[] args) {

        class Clock {
            Integer ClockNumber;
            Integer hour;
            Integer minute;
            Integer second;
            LocalTime time;
            LocalDateTime time2;

            public Clock(int ClockNumber, int hour, int minute, int second) {
                this.ClockNumber=ClockNumber;
                this.hour=hour;
                this.minute=minute;
                this.second=second;
                this.time = LocalTime.of(hour,minute,second);
            }

            public LocalTime addMinute() {
                return time.plusMinutes(1);
            }

            public String toString() {
                return "Clock #"+ClockNumber+" time is: "+time;
            }
        }

        Clock clock1 = new Clock(1,01,30,45);
        Clock clock2 = new Clock(2,05,10,15);
        Clock clock3 = new Clock(3,13,49,20);
        Clock clock4 = new Clock(4,15,02,01);
        Clock clock5 = new Clock(5,23,59,59);
        Clock clock6 = new Clock(6,11,12,13);

        System.out.println(clock1);
        System.out.println(clock2);
        System.out.println(clock3);
        System.out.println(clock4);
        System.out.println(clock5);
        System.out.println(clock6);

        LinkedList<Clock> clockList = new LinkedList<Clock>();
        clockList.add(clock1);
        clockList.add(clock2);
        clockList.add(clock3);
        clockList.add(clock4);
        clockList.add(clock5);
        clockList.add(clock6);

        System.out.println("\nIncrementing time by 1 minute in each clock:\n");

        //Adding 1 minute to each of the clock:
        for(int n = 0; n < clockList.size(); n++) {
            System.out.println("Clock #"+(n+1)+": "+clockList.get(n).addMinute());

        }

    }
}