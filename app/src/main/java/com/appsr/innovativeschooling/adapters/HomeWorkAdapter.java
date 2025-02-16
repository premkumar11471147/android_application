package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.HomeWork;

import java.util.List;

public class HomeWorkAdapter extends RecyclerView.Adapter<HomeWorkAdapter.ViewHolder> {
    private List<HomeWork> homeworkList;
    private Context context;

    public HomeWorkAdapter(Context context, List<HomeWork> homeworkList) {
        this.context = context;
        this.homeworkList = homeworkList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_work, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeWork homework = homeworkList.get(position);
        holder.description.setText(homework.getDescription());
    }

    @Override
    public int getItemCount() {
        return homeworkList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.textDescription);
        }
    }
}
