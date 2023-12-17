package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, "Keks13", 'M', LocalDate.of(1988, Month.FEBRUARY, 5),11));
        forumUserList.add(new ForumUser(2, "sebik", 'M', LocalDate.of(2007, Month.OCTOBER, 22),98));
        forumUserList.add(new ForumUser(3, "Kermit75", 'M', LocalDate.of(1997, Month.DECEMBER, 30),30));
        forumUserList.add(new ForumUser(4, "Natalia12345", 'F', LocalDate.of(1968, Month.APRIL, 25),85));
        forumUserList.add(new ForumUser(5, "iza84", 'F', LocalDate.of(1984, Month.NOVEMBER, 16),7));
        forumUserList.add(new ForumUser(6, "User122", 'M', LocalDate.of(2000, Month.SEPTEMBER, 17),168));
        forumUserList.add(new ForumUser(7, "Lily55", 'F', LocalDate.of(1988, Month.MAY, 25),0));
        forumUserList.add(new ForumUser(8, "djpawel", 'M', LocalDate.of(1992, Month.JULY, 3),3));
        forumUserList.add(new ForumUser(9, "Petronella", 'F', LocalDate.of(2003, Month.SEPTEMBER, 14),4));
        forumUserList.add(new ForumUser(10, "Amelia90", 'F', LocalDate.of(1996, Month.OCTOBER, 9),0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}