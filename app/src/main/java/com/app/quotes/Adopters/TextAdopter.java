package com.app.quotes.Adopters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.quotes.R;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;

public class TextAdopter extends RecyclerView.Adapter<TextAdopter.ViewHolder> {
    ArrayList<TextModel> textModels;
    Context context;

    public TextAdopter(ArrayList<TextModel> textModels, Context context) {
        this.textModels = textModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(textModels.get(position).getText());
        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", holder.textView.getText());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context,"Text copied",Toast.LENGTH_LONG).show();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Create an ACTION_SEND Intent*/
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = "Here is the share content body";
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, context.getResources().getString(R.string.app_name));
                intent.putExtra(android.content.Intent.EXTRA_TEXT, holder.textView.getText());
                /*Fire!*/
                context.startActivity(Intent.createChooser(intent, holder.textView.getText()));
            }
        });
        holder.whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = "Here is the share content body";
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, context.getResources().getString(R.string.app_name));
                intent.putExtra(android.content.Intent.EXTRA_TEXT, holder.textView.getText());

                intent.setPackage("com.whatsapp");
                /*Fire!*/
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
        ImageView share,copy,whatsApp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            share=itemView.findViewById(R.id.share);
            copy=itemView.findViewById(R.id.copy);
            whatsApp=itemView.findViewById(R.id.whatsapp);




        }
    }
}
