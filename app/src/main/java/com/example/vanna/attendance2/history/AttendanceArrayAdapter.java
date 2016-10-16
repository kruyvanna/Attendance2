package com.example.vanna.attendance2.history;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vanna.attendance2.R;

/**
 * Created by vanna on 9/8/16.
 */

public class AttendanceArrayAdapter extends RecyclerView.Adapter<AttendanceArrayAdapter.ViewHolder> {
    private Attendance[] data;
    private Activity activity;
    private AttendanceAdapterListener attendanceAdapterListener;

    public void setAttendanceAdapterListener(AttendanceAdapterListener attendanceAdapterListener){
        this.attendanceAdapterListener = attendanceAdapterListener;
    }


    public AttendanceArrayAdapter(Activity parent_activity, Attendance[] data) {
        this.activity = parent_activity;
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView statusView;
        TextView dateView;
        TextView timeView;

        public ViewHolder(View itemView) {
            super(itemView);
            statusView = (TextView) itemView.findViewById(R.id.statusView);

            Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/icomoon.ttf");
            statusView.setTypeface(typeface);
            statusView.setText("\ue901");

            statusView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Adapter: ", "position: " + getAdapterPosition());
                    attendanceAdapterListener.onStatusClick(getAdapterPosition());
                }
            });

            dateView = (TextView) itemView.findViewById(R.id.dateView);
            timeView = (TextView) itemView.findViewById(R.id.timeView);
        }

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View attandanceRowView = inflater.inflate(R.layout.attendance_item_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(attandanceRowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Attendance attendance = data[position];
        holder.dateView.setText(attendance.date);
        holder.timeView.setText(attendance.time);
    }
}
