package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.TeacherProfile;

import java.util.List;

import android.widget.ImageButton;

import java.util.ArrayList;

public class TeacherProfileAdapter extends RecyclerView.Adapter<TeacherProfileAdapter.TeacherViewHolder> {

    private List<TeacherProfile> teacherList = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditClick(TeacherProfile teacher);
        void onDeleteClick(TeacherProfile teacher);
    }

    public TeacherProfileAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_profile, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        TeacherProfile teacher = teacherList.get(position);
        holder.tvTeacherName.setText(teacher.getFirstName() + " " + teacher.getLastName());
        holder.tvTeacherId.setText("ID: " + teacher.getTeacher_id());

        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(teacher));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(teacher));
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public void setTeacherList(List<TeacherProfile> teachers) {
        this.teacherList = teachers;
        notifyDataSetChanged();
    }

    static class TeacherViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeacherName, tvTeacherId;
        ImageButton btnEdit, btnDelete;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvTeacherId = itemView.findViewById(R.id.tvTeacherId);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

