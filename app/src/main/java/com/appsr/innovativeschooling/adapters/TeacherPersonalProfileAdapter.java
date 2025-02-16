package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.TeacherPersonalProfile;

import java.util.List;
import android.widget.ImageView;

public class TeacherPersonalProfileAdapter extends RecyclerView.Adapter<TeacherPersonalProfileAdapter.ViewHolder> {

    private List<TeacherPersonalProfile> teacherPersonalProfiles;
    private final OnItemClickListener listener;
    private final Context context;

    public interface OnItemClickListener {
        void onEditClick(TeacherPersonalProfile profile);
        void onDeleteClick(TeacherPersonalProfile profile);
    }

    public TeacherPersonalProfileAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setTeacherPersonalProfiles(List<TeacherPersonalProfile> teacherPersonalProfiles) {
        this.teacherPersonalProfiles = teacherPersonalProfiles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_personal_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherPersonalProfile profile = teacherPersonalProfiles.get(position);
        holder.tvTeacherName.setText(profile.getMother_name() + " " + profile.getFather_name());
        holder.tvPhoneNumber.setText(profile.getPhone_number());

        holder.ivEdit.setOnClickListener(v -> listener.onEditClick(profile));
        holder.ivDelete.setOnClickListener(v -> listener.onDeleteClick(profile));
    }

    @Override
    public int getItemCount() {
        return teacherPersonalProfiles == null ? 0 : teacherPersonalProfiles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeacherName, tvPhoneNumber;
        ImageView ivEdit, ivDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            ivDelete = itemView.findViewById(R.id.ivDelete);
        }
    }
}

