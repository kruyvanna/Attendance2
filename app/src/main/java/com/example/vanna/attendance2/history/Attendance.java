package com.example.vanna.attendance2.history;

/**
 * Created by vanna on 9/8/16.
 */

enum Status {
    Present, Absent, Permission
}

public class Attendance {
    String date;
    String time;
    Status status;

    public Attendance(String date, String time, Status status) {
        this.date = date;
        this.time = time;
        this.status = status;
    }
}
