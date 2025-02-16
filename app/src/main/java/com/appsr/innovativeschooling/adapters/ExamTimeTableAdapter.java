package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.activities.AddEditExamActivity;
import com.appsr.innovativeschooling.activities.ExamTimeTableActivity;
import com.appsr.innovativeschooling.models.ExamTimeTable;

import java.util.List;

import android.content.Intent;
import android.widget.ImageView;
import java.util.ArrayList;

public class ExamTimeTableAdapter extends RecyclerView.Adapter<ExamTimeTableAdapter.ExamViewHolder> {

    private Context context;
    private List<ExamTimeTable> examList = new ArrayList<>();

    public ExamTimeTableAdapter(Context context) {
        this.context = context;
    }

    public void setExamList(List<ExamTimeTable> exams) {
        this.examList = exams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exam_time_table, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        ExamTimeTable exam = examList.get(position);
        holder.textExamName.setText(exam.getExam_name());
        holder.textSubject.setText("Subject: " + exam.getSubject());
        holder.textDate.setText("Date: " + exam.getDate());
        holder.textTime.setText("Time: " + exam.getTime());

        holder.imageEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddEditExamActivity.class);
            intent.putExtra("exam_id", exam.getExam_time_table_id());
            context.startActivity(intent);
        });

        holder.imageDelete.setOnClickListener(v -> {
            if (context instanceof ExamTimeTableActivity) {
                ((ExamTimeTableActivity) context).deleteExam(exam);
            }
        });
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    static class ExamViewHolder extends RecyclerView.ViewHolder {
        TextView textExamName, textSubject, textDate, textTime;
        ImageView imageEdit, imageDelete;

        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            textExamName = itemView.findViewById(R.id.textExamName);
            textSubject = itemView.findViewById(R.id.textSubject);
            textDate = itemView.findViewById(R.id.textExamDate);
            textTime = itemView.findViewById(R.id.textExamTime);
            imageEdit = itemView.findViewById(R.id.imageEdit);
            imageDelete = itemView.findViewById(R.id.imageDelete);
        }
    }
}

