package com.trial.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SummeryAdopter extends RecyclerView.Adapter<SummeryAdopter.ViewHolder> {
    ArrayList<Model> models;
    Context context;

    public SummeryAdopter(ArrayList<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.summery_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model currentModel=models.get(position);
        holder.title.setText(currentModel.getTitle());
        holder.occurrence.setText(currentModel.getOccurrence());
        if (currentModel.getSymbol().equals("error")){
            holder.symbol.setImageResource(R.drawable.error);
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.back_outline_red));
        }
        else{
            holder.symbol.setImageResource(R.drawable.check);
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.back_outline_green));
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private TextView title,occurrence;
        private ImageView symbol;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            occurrence=itemView.findViewById(R.id.occurrence);
            symbol=itemView.findViewById(R.id.symbol);
            layout=itemView.findViewById(R.id.linear_layout);
        }
    }
}
