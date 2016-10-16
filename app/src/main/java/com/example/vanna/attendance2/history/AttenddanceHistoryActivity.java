package com.example.vanna.attendance2.history;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vanna.attendance2.R;

public class AttenddanceHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attenddance_history);

        initLayout();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // setup adapter
        Attendance[] data = getAttendanceData();
        AttendanceArrayAdapter adapter = new AttendanceArrayAdapter(this, data);
        adapter.setAttendanceAdapterListener(new AttendanceAdapterListener() {
            @Override
            public void onStatusClick(int position) {
                Log.d("AttendanceActivity: ", "on Listener, received position: " + position);
                visibleLayout(position);
            }
        });
        recyclerView.setAdapter(adapter);

        // setup layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initLayout(){
        TextView buttonClose = (TextView)findViewById(R.id.statusClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invisibleLayout();
            }
        });
    }

    private void invisibleLayout(){
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.statusDetailLayout);
        relativeLayout.setVisibility(View.INVISIBLE);
    }

    private void visibleLayout(int position){
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.statusDetailLayout);
        relativeLayout.setVisibility(View.VISIBLE);

        TextView textView = (TextView)findViewById(R.id.statusDetailView);
        textView.setText("Clicked on position: " + position);

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
