package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.StudentPersonalProfile;

import java.util.List;

import android.widget.Button;

import java.util.ArrayList;

public class StudentPersonalProfileAdapter extends RecyclerView.Adapter<StudentPersonalProfileAdapter.ViewHolder> {

    private List<StudentPersonalProfile> studentPersonalProfiles = new ArrayList<>();
    private OnItemClickListener listener;

    public StudentPersonalProfileAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setStudentPersonalProfiles(List<StudentPersonalProfile> studentPersonalProfiles) {
        this.studentPersonalProfiles = studentPersonalProfiles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_personal_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentPersonalProfile profile = studentPersonalProfiles.get(position);
        holder.tvName.setText(profile.getFather_name() + " / " + profile.getMother_name());
        holder.tvPhone.setText("Phone: " + profile.getPhone_number());

        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(profile));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(profile));
    }

    @Override
    public int getItemCount() {
        return studentPersonalProfiles.size();
    }

    public interface OnItemClickListener {
        void onEditClick(StudentPersonalProfile studentPersonalProfile);
        void onDeleteClick(StudentPersonalProfile studentPersonalProfile);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;
        Button btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

