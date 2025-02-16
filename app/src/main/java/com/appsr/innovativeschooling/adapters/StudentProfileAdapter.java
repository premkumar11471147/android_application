package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.StudentProfile;

import java.util.List;

import android.widget.ImageButton;

public class StudentProfileAdapter extends RecyclerView.Adapter<StudentProfileAdapter.StudentViewHolder> {

    private List<StudentProfile> studentList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditClick(StudentProfile student);
        void onDeleteClick(StudentProfile student);
    }

    public StudentProfileAdapter(OnItemClickListener listener, List<StudentProfile> studentList) {
        this.listener = listener;
        this.studentList = studentList;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        StudentProfile student = studentList.get(position);
        holder.tvStudentName.setText(student.getFirstName() + " " + student.getLastName());
        holder.tvRollNumber.setText("Roll No: " + student.getRollNumber());
        holder.tvClassId.setText("Class ID: " + student.getClassId());
        holder.tvSchoolId.setText("School ID: " + student.getSchoolId());

        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(student));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(student));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void updateList(List<StudentProfile> newList) {
        this.studentList = newList;
        notifyDataSetChanged();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudentName, tvRollNumber, tvClassId, tvSchoolId;
        ImageButton btnEdit, btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvRollNumber = itemView.findViewById(R.id.tvRollNumber);
            tvClassId = itemView.findViewById(R.id.tvClassId);
            tvSchoolId = itemView.findViewById(R.id.tvSchoolId);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

