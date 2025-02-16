package com.appsr.innovativeschooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsr.innovativeschooling.R;
import com.appsr.innovativeschooling.models.Fees;

import java.util.List;

public class FeesAdapter extends RecyclerView.Adapter<FeesAdapter.ViewHolder> {
    private List<Fees> feesList;
    private Context context;

    public FeesAdapter(Context context, List<Fees> feesList) {
        this.context = context;
        this.feesList = feesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fees, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fees fees = feesList.get(position);
        holder.amount.setText("Amount: " + fees.getTotal_amount());
        holder.date.setText("Date: " + fees.getDate());
    }

    @Override
    public int getItemCount() {
        return feesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.textAmount);
            date = itemView.findViewById(R.id.textDate);
        }
    }
}
