package com.example.vanna.attendance2.history;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vanna.attendance2.R;

public class AttenddanceHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attenddance_history);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // setup adapter
        Attendance[] data = getAttendanceData();
        AttendanceArrayAdapter adapter = new AttendanceArrayAdapter(data);
        recyclerView.setAdapter(adapter);

        // setup layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private Attendance[] getAttendanceData() {
        Attendance[] data = new Attendance[6];

        for (int i = 0; i< 6; i++) {
            Attendance attendance = new Attendance("2016/08/0" + i, "5:30 PM", Status.Present);
            data[i] = attendance;
        }

        return data;
    }
}
