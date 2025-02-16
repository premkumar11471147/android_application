package com.appsr.innovativeschooling.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.TeacherAttendance;

import java.util.List;

import android.widget.ImageButton;

import java.util.ArrayList;

public class TeacherAttendanceAdapter extends RecyclerView.Adapter<TeacherAttendanceAdapter.TeacherAttendanceViewHolder> {

    private List<TeacherAttendance> teacherAttendanceList = new ArrayList<>();
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditClick(TeacherAttendance attendance);
        void onDeleteClick(TeacherAttendance attendance);
    }

    public TeacherAttendanceAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setTeacherAttendanceList(List<TeacherAttendance> attendanceList) {
        this.teacherAttendanceList = attendanceList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeacherAttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_attendance, parent, false);
        return new TeacherAttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherAttendanceViewHolder holder, int position) {
        TeacherAttendance attendance = teacherAttendanceList.get(position);
        holder.textViewTeacherReason.setText(attendance.getAbsent_reason());
        holder.textViewDate.setText(attendance.getDate());
        holder.textViewStatus.setText(attendance.getAttendance_status());

        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(attendance));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(attendance));
    }

    @Override
    public int getItemCount() {
        return teacherAttendanceList.size();
    }

    static class TeacherAttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTeacherReason, textViewDate, textViewStatus;
        ImageButton btnEdit, btnDelete;

        public TeacherAttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTeacherReason = itemView.findViewById(R.id.textViewTeacherName);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

