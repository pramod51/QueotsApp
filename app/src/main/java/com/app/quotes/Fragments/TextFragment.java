package com.app.quotes.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.quotes.Adopters.TextAdopter;
import com.app.quotes.Adopters.TextModel;
import com.app.quotes.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class TextFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<TextModel> textModels;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_text, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseFirestore.getInstance().collection(getArguments().getString("key")).document("Text").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                textModels=new ArrayList<>();
                for (int i=1;i<=documentSnapshot.getData().size();i++){
                    int finalI = i;
                    FirebaseFirestore.getInstance().collection(getArguments().getString("key")).document("Text").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            textModels.add(new TextModel(documentSnapshot.getString(""+ finalI)));
                            Log.v("tag",textModels.size()+"nner");

                            adapter=new TextAdopter(textModels,getContext());
                            recyclerView.setAdapter(adapter);
                        }
                    });
                }
                Log.v("tag",textModels.size()+"outer");

            }
        });



        return view;
    }
}