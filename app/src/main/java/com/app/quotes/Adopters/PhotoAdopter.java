package com.app.quotes.Adopters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.quotes.ImageActivity;
import com.app.quotes.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;

public class PhotoAdopter extends RecyclerView.Adapter<PhotoAdopter.ViewHolder> {
    ArrayList<TextModel> textModels;
    Context context;

    public PhotoAdopter(ArrayList<TextModel> textModels, Context context) {
        this.textModels = textModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(textModels.get(position).getText()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("key",textModels.get(position).getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return textModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView,copy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);


        }
    }
}
