package com.example.unit3eval1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ResponseModel> modelList;

    public Adapter(List<ResponseModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
       ResponseModel responseModel=modelList.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
