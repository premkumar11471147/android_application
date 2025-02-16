package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.StudentAttendance;

import java.util.List;

import android.widget.ImageView;
import java.util.ArrayList;

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceAdapter.AttendanceViewHolder> {
    private List<StudentAttendance> attendanceList = new ArrayList<>();

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_attendance, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        StudentAttendance attendance = attendanceList.get(position);
        holder.textViewStudentId.setText("ID: " + attendance.getStudentId());
        holder.textViewDate.setText("Date: " + attendance.getDate());
        holder.textViewStatus.setText("Status: " + (attendance.isPresent() ? "Present" : "Absent"));

        holder.imageViewEdit.setOnClickListener(v -> {
            // Handle edit click
        });

        holder.imageViewDelete.setOnClickListener(v -> {
            // Handle delete click
        });
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    public void setAttendanceList(List<StudentAttendance> attendances) {
        this.attendanceList = attendances;
        notifyDataSetChanged();
    }

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView textViewStudentId, textViewDate, textViewStatus;
        ImageView imageViewEdit, imageViewDelete;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStudentId = itemView.findViewById(R.id.textViewStudentId);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            imageViewEdit = itemView.findViewById(R.id.imageViewEdit);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
        }
    }
}
