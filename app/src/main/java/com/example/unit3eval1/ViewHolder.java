package com.example.unit3eval1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivimage;
    private TextView tvview;
    private TextView tvsubview;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);
    }

    private void initviews(View itemView) {
        ivimage=itemView.findViewById(R.id.ivimage);
        tvview=itemView.findViewById(R.id.tvtitle);
        tvsubview=itemView.findViewById(R.id.tvsubtitle);
    }
    public void setData(ResponseModel model){
        ivimage.setImageResource(model.getImage());
        tvview.setText(model.getTitle());
        tvsubview.setText(model.getSubTitle());
    }
}
